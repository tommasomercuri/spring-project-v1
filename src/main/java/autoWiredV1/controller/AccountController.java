package autoWiredV1.controller;

import autoWiredV1.model.Account;
import autoWiredV1.model.DataRequest;
import autoWiredV1.model.User;
import autoWiredV1.services.CreateNewAccountService;
import autoWiredV1.services.CreateNewUserService;
import autoWiredV1.services.PutIntoLocalMapRepoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

@RestController
@RequestMapping("/api")
public class AccountController {
    CreateNewAccountService createNewAccountService;
    CreateNewUserService createNewUserService;
    PutIntoLocalMapRepoService putIntoLocalMapRepoService;
    public AccountController(CreateNewAccountService createNewAccountService) {
        this.createNewAccountService = createNewAccountService;
    }

    @PostMapping("/createAccount")
    public String createAccountPOST(@RequestBody Account accountRequest){
        return (
                createNewAccountService.createNewAccount(
                        accountRequest.getEmail(),
                        accountRequest.getPassword()
                )
        ).toString();
    }

    @PostMapping("/createUser")
        public String createUserPOST(@RequestBody User userRequest){
            return (
                    createNewUserService.createNewUser(
                            userRequest.getName(),
                            userRequest.getBornYear()
                    )
            ).toString();
    }

    @PostMapping("/create")
    public boolean createUserPOST(@RequestBody DataRequest dataRequest){
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

}

