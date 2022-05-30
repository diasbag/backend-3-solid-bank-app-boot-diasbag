package com.example.demo.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    long  id;
    double amount;
}
