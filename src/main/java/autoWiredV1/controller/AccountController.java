package autoWiredV1.controller;

import autoWiredV1.model.base.Account;
import autoWiredV1.model.dto.DataRequest;
import autoWiredV1.model.base.User;
import autoWiredV1.services.AccountService;
import autoWiredV1.services.UserService;
import autoWiredV1.services.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/createAccount")
    public String createAccountPOST(@RequestBody Account accountRequest) {
        return (
                accountService.createNewAccount(
                        accountRequest.getEmail(),
                        accountRequest.getPassword()
                )
        ).toString();
    }

    @GetMapping("/printAccountData")
    public Account printAccountDataGET() {
        return null;
    }

}

