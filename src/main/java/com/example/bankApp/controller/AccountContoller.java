package com.example.bankApp.controller;

import com.example.bankApp.dto.AccountDto;
import com.example.bankApp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/accounts")
@RestController
public class AccountContoller {

    public AccountContoller(AccountService accountService) {
        this.accountService = accountService;
    }

    private AccountService accountService;


    // add account restapi
    @PostMapping("/create")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        AccountDto SavedaccountDto=accountService.createAccount(accountDto);
        return new ResponseEntity<>(SavedaccountDto,HttpStatus.CREATED);

    }

    // get by id
    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // get all employees api
    @GetMapping("/allaccounts")
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        List<AccountDto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
       AccountDto accountDto= accountService.deposit(id,amount);
       return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withDraw(@PathVariable Long id,@RequestBody Map<String,Double> request ){
        Double amount=request.get("amount");
        AccountDto accountDto= accountService.withDraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
}
