package com.nttdata.controller;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.repository.AccountQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {
    private final AccountQueryService accountQueryService;
    @PostMapping("/createAccount")
    public Account createAccountPOST(@RequestBody CreateAccountDto accountRequest) {
        return accountQueryService.createNewAccount(accountRequest);
    }
    //DEVO RITORNARE UNA MAPPA
    @GetMapping("/getAll")
    public String getAccountsGET() {
        return accountQueryService.getAllMap();
    }
    @GetMapping("/get/{id}")
    public Account getAccountGET(@PathVariable String id) {
        return accountQueryService.retrieveAccountById(id);
    }

    //PATH PARAM
    @PatchMapping(value = "/email/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)  //PATCH
    public boolean updateAccountEmailByIdPATCH(@PathVariable String id, @RequestBody String email) {
        return accountQueryService.updateAccountEmailById(id, email);
    }
    @PatchMapping(value = "/password/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)  //PATCH
    public boolean updateAccountPasswordByIdPATCH(@PathVariable String id, @RequestBody String password) {
        return accountQueryService.updateAccountPasswordById(id, password);
    }
    @PatchMapping(value = "/delete/{id}")  //PATCH
    public boolean deleteAccountByIdPATCH(@PathVariable String id) {
        return accountQueryService.deleteAccountById(id);
    }

}

