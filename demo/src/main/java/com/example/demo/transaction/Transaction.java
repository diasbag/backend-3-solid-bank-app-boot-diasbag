package com.example.demo.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Transaction {
    int id;
    double amount;
}
