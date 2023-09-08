package com.nttdata.controller;

import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.services.repository.UserQueryService;
import com.nttdata.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserQueryService userQueryService;
    @PostMapping("/createUser")
    public String createUserPOST(@RequestBody CreateUserDto userRequest) {
        return (userQueryService.createNewUser(userRequest)).toString();
    }

    //Da fixare
    @GetMapping("/retrieveUserById")
    public String createUserPOST() {
        return userQueryService.retrieveUserById("").toString();
    }
}
