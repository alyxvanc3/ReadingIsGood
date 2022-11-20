package com.company.readingIsGood.order.service;

import com.company.readingIsGood.book.Book;
import com.company.readingIsGood.order.*;
import com.company.readingIsGood.order.repository.OrderDetailsRepository;
import com.company.readingIsGood.order.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Order> getOrdersByCustomerNo(int customerNo, Pageable pageable) {
        List<OrderEntity> orders = orderRepository.findAllByCustomer(customerNo, pageable);

        List<Order> orderDtoList = orders
                .stream()
                .map(order -> modelMapper.map(order, Order.class))
                .collect(Collectors.toList());

        return orderDtoList;

        }

    @Override
    public void saveOrder(Order order) {
        OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
        orderRepository.save(orderEntity);
    }

    @Override
    public Order getOrderById(long orderId) {
        Optional<OrderEntity> order = orderRepository.findById(orderId);

        List<OrderDetailsEntity> orderDetails = orderDetailsRepository.findAllByOrderId(orderId);
        Map<Book, Integer> books = new HashMap<>();

        for (OrderDetailsEntity entity: orderDetails) {
            books.put(modelMapper.map(entity.getBook(), Book.class), entity.getQuantity());
        }

        Order orderDto = modelMapper.map(order, Order.class);
        orderDto.setBooks(books);

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
