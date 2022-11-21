package com.company.readingIsGood.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    public String status;
    public String message;
    public String time;
}