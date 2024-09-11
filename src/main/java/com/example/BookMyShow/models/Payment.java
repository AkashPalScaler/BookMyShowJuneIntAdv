package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private int amount;
    private String reference;
    @Enumerated(value = EnumType.STRING)
    private PaymentMode paymentMode;
    @Enumerated(value = EnumType.STRING)
    private PaymentGateway paymentGateway;
    @Enumerated(value = EnumType.STRING)
    private PaymentStatus paymentStatus;
}
