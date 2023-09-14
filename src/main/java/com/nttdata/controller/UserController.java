package com.nttdata.controller;

import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.UserCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

@RequestMapping("/api/user")
public class UserController {
    @Autowired
    @Qualifier("userDb")
    private UserCrud userCrud;

    //private final UserQueryService userQueryService;

    @PostMapping("/createUser")
    public User insertUserPOST(@RequestBody CreateUserDto userRequest) {
        return userCrud.insertNewUser(userRequest);
    }
    @GetMapping("/getAll")
    public String getAccountsGET() {
        return userCrud.getAll();
    }
    @GetMapping("/get/{id}")
    public User getUserGET(@PathVariable String id) {
        return userCrud.retrieveUserById(id);
    }
    @PatchMapping(value = "/email/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)  //PATCH
    public boolean updateUserNameByIdPATCH(@PathVariable String id, @RequestBody String name) {
        return userCrud.updateUserNameById(id, name);
    }
    @PatchMapping(value = "/delete/{id}")  //PATCH
    public boolean deleteUserByIdPATCH(@PathVariable String id) {
        return userCrud.deleteUser(id);
    }
}
