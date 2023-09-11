package com.nttdata.controller;

import com.nttdata.model.base.Account;
import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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
    @GetMapping("/getAll")
    public String getAccountsGET() {
        return userQueryService.getAllMap();
    }
    @GetMapping("/get/{id}")
    public User getUserGET(@PathVariable String id) {
        return userQueryService.retrieveUserById(id);
    }
    @PatchMapping(value = "/email/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)  //PATCH
    public boolean updateUserNameByIdPATCH(@PathVariable String id, @RequestBody String name) {
        return userQueryService.updateNameById(id, name);
    }
    @PatchMapping(value = "/delete/{id}")  //PATCH
    public boolean deleteUserByIdPATCH(@PathVariable String id) {
        return userQueryService.deleteUser(id);
    }
}
