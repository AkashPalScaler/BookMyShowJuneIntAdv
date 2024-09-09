package com.example.BookMyShow.models;

public class Payment extends BaseModel{
    private int amount;
    private String reference;
    private PaymentMode paymentMode;
    private PaymentGateway paymentGateway;
    private PaymentStatus paymentStatus;
}
