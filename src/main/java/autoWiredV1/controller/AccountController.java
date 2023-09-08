package autoWiredV1.controller;

import autoWiredV1.model.Account;
import autoWiredV1.model.DataRequest;
import autoWiredV1.model.User;
import autoWiredV1.services.CreateNewAccountService;
import autoWiredV1.services.CreateNewUserService;
import autoWiredV1.services.GetLocalMapRepoService;
import autoWiredV1.services.PutIntoLocalMapRepoService;
import autoWiredV1.services.impl.CreateNewAccountServiceImpl;
import autoWiredV1.services.impl.CreateNewUserServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping("/api")
public class AccountController {

    @Autowired
    CreateNewAccountService createNewAccountService;
    @Autowired
    CreateNewUserService createNewUserService;
    @Autowired
    PutIntoLocalMapRepoService putIntoLocalMapRepoService;
    @Autowired
    GetLocalMapRepoService getLocalMapRepoService;

    @PostMapping("/createAccount")
    public String createAccountPOST(@RequestBody Account accountRequest) {
        return (
                createNewAccountService.createNewAccount(
                        accountRequest.getEmail(),
                        accountRequest.getPassword()
                )
        ).toString();
    }

    @PostMapping("/createUser")
    public String createUserPOST(@RequestBody User userRequest) {
        return (
                createNewUserService.createNewUser(
                        userRequest.getName(),
                        userRequest.getBornYear()
                )
        ).toString();
    }

    @PostMapping("/create")
    public boolean createUserPOST(@RequestBody DataRequest dataRequest) {
        return putIntoLocalMapRepoService.
                putIntoLocalMap(
                        createNewAccountService.createNewAccount(
                                dataRequest.getAccount().getEmail(),
                                dataRequest.getAccount().getPassword()
                        ),
                        createNewUserService.createNewUser(
                                dataRequest.getUser().getName(),
                                dataRequest.getUser().getBornYear()
                        )
                );
    }

    @GetMapping("/printData")
    public String createUserPOST() {
        return getLocalMapRepoService.getMap();
    }
}

