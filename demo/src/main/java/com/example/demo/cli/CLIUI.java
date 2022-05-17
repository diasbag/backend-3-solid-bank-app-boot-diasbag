package com.example.demo.cli;

import com.example.demo.CreateAccountOperationUI;
import org.springframework.stereotype.Service;

@Service
public interface CLIUI extends CreateAccountOperationUI, WithdrawDepositOperationCLIUI {

}
