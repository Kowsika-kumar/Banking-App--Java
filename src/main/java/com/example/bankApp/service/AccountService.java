package com.example.bankApp.service;

import com.example.bankApp.dto.AccountDto;
import com.example.bankApp.entity.Account;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    List<AccountDto>  getAllAccounts();

    AccountDto deposit(Long id,Double amount);

    AccountDto withDraw(Long id,Double amount);
}
