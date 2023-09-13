package com.nttdata.controller;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.model.dto.account.CreatedResponse;
import com.nttdata.repository.AccountCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    @Qualifier("accountDb")
    private AccountCrud accountCrud;
    //Non utilizzo constructor Injection per Qualifier
       //private final AccountQueryService accountQueryService;

    @PostMapping("/createAccount")
    public Account insertAccountPOST(@RequestBody CreateAccountDto accountRequest) {
        return accountCrud.insertNewAccount(accountRequest);
    }


    @GetMapping("/getAll")
    public String getAccountsGET() {
        return accountCrud.getAll();
    }
    @GetMapping("/get/{id}")
    public Account getAccountGET(@PathVariable String id) {
        return accountCrud.retrieveAccountById(id);
    }

    //PATH PARAM
    @PatchMapping(value = "/email/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)  //PATCH
    public boolean updateAccountEmailByIdPATCH(@PathVariable String id, @RequestBody String email) {
        return accountCrud.updateAccountEmailById(id, email);
    }
    @PatchMapping(value = "/password/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)  //PATCH
    public boolean updateAccountPasswordByIdPATCH(@PathVariable String id, @RequestBody String password) {
        return accountCrud.updateAccountPasswordById(id, password);
    }
    @PatchMapping(value = "/delete/{id}")  //PATCH
    public boolean deleteAccountByIdPATCH(@PathVariable String id) {
        return accountCrud.deleteAccountById(id);
    }

}

