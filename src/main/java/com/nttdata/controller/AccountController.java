package com.nttdata.controller;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.services.account.AccountService;
import com.nttdata.services.repository.AccountQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {
    private final AccountQueryService accountQueryService;

    //Restituisce account
    @PostMapping("/createAccount")
    public String createAccountPOST(@RequestBody CreateAccountDto accountRequest) {
        return (accountQueryService.createNewAccount(accountRequest)).toString();
    }

    @GetMapping("/printAccountData")
    public Account printAccountDataGET() {
        return null;
    }

}

