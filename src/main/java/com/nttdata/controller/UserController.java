package com.nttdata.controller;

import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserQueryService userQueryService;
    @PostMapping("/createUser")
    public User createUserPOST(@RequestBody CreateUserDto userRequest, String idAccount) {
        return userQueryService.createNewUser(userRequest, idAccount);
    }

    //Da fixare
    @GetMapping("/retrieveUserById")
    public String createUserPOST() {
        return userQueryService.retrieveUserById("").toString();
    }
}
