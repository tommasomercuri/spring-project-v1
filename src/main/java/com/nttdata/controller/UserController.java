package com.nttdata.controller;

import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.services.repository.UserQueryService;
import com.nttdata.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserQueryService userQueryService;
    @PostMapping("/createUser")
    public String createUserPOST(@RequestBody CreateUserDto userRequest) {
        return (userQueryService.createNewUser(userRequest)).toString();
    }
}
