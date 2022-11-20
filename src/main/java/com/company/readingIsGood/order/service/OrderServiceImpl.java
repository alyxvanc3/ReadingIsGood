package com.company.readingIsGood.order.service;

import com.company.readingIsGood.book.Book;
import com.company.readingIsGood.book.BookEntity;
import com.company.readingIsGood.book.BookRepository;
import com.company.readingIsGood.book.service.BookService;
import com.company.readingIsGood.customer.Customer;
import com.company.readingIsGood.customer.CustomerEntity;
import com.company.readingIsGood.customer.CustomerRepository;
import com.company.readingIsGood.order.entity.OrderDetailEntity;
import com.company.readingIsGood.order.entity.OrderEntity;
import com.company.readingIsGood.order.model.Order;
import com.company.readingIsGood.order.model.OrderDetail;
import com.company.readingIsGood.order.repository.OrderDetailsRepository;
import com.company.readingIsGood.order.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Order> getOrdersByCustomerId(Customer customer, Pageable pageable) {
        Page<OrderEntity> pageOrders = orderRepository.findAllByCustomer(modelMapper.map(customer, CustomerEntity.class), pageable);
        List<OrderEntity> orders = pageOrders.getContent();

        List<Order> orderDtoList = orders
                .stream()
                .map(order -> modelMapper.map(order, Order.class))
                .collect(Collectors.toList());

        return orderDtoList;

        }

    @Override
    public void saveOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity();

        CustomerEntity customer = customerRepository.findById(order.getCustomerId()).get();

        orderEntity.setCustomer(customer);
        orderEntity.setOperationDate(order.getOperationDate());

        List<OrderDetailEntity> orderDetails = new ArrayList<>();

        for (OrderDetail orderDetail: order.getOrderDetails()) {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();

            BookEntity bookEntity = bookRepository.findByIsbn(orderDetail.getBook().getIsbn());

            orderDetailEntity.setBook(bookEntity);
            orderDetailEntity.setQuantity(orderDetail.getQuantity());
            orderDetailEntity.setOrderEntity(orderEntity);

            orderDetailsRepository.save(orderDetailEntity);
            orderDetails.add(orderDetailEntity);

            Book book = modelMapper.map(bookEntity, Book.class);

            updateStock(book, book.getQuantity()-orderDetail.getQuantity());
        }
        orderEntity.setOrderDetails(orderDetails);

        orderRepository.save(orderEntity);
    }

    private void updateStock(Book book, int quantity) {
        book.setQuantity(quantity);
        bookService.updateQuantity(book);
    }

    @Override
    public Order getOrderById(long orderId) {
        OrderEntity order = orderRepository.findById(orderId).get();

        List<OrderDetailEntity> orderDetails = orderDetailsRepository.findAllByOrderEntity(order);
        List<OrderDetail> orderDetailsDto = new ArrayList<>();

        for (OrderDetailEntity entity: orderDetails) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(entity.getId());
            orderDetail.setOrderId(entity.getOrderEntity().getId());

            BookEntity bookEntity = bookRepository.findById(entity.getBook().getId()).get();

            orderDetail.setBook(modelMapper.map(bookEntity, Book.class));
            orderDetail.setQuantity(entity.getQuantity());

            orderDetailsDto.add(orderDetail);
        }

        Order orderDto = modelMapper.map(order, Order.class);
        orderDto.setOrderDetails(orderDetailsDto);

        return orderDto;
    }

    @Override
    public List<Order> getOrdersByDate(Date startDate, Date endDate) {
        List<OrderEntity> orders = orderRepository.getAllBetweenDates(startDate, endDate);

        List<Order> orderDtoList = orders
                .stream()
                .map(order -> modelMapper.map(order, Order.class))
                .collect(Collectors.toList());

        return orderDtoList;
    }
}
