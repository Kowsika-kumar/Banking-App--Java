package com.example.bankApp.service.impl;

import com.example.bankApp.dto.AccountDto;
import com.example.bankApp.entity.Account;
import com.example.bankApp.exception.ResourceNotFoundException;
import com.example.bankApp.mapper.AccountMapper;
import com.example.bankApp.repository.AccountRepository;
import com.example.bankApp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account=accountRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("id not found: "+ id));
        return AccountMapper.mapToAccountDto(account);

    }


    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream()
                .map(account -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {
        Account account=accountRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("id not found: "+id));
        Double total=account.getBalance()+amount;
        account.setBalance(total);
        Account saved=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saved);

    }

    @Override
    public AccountDto withDraw(Long id, Double amount) {
        Account account=accountRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("id not found: "+id));
        if(account.getBalance()<amount){
            throw new RuntimeException("insufficient amount");

        }
        Double total=account.getBalance()-amount;
        account.setBalance(total);
        Account saved=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saved);
    }
}
