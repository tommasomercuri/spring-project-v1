package com.nttdata.controller;

import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.UserDao;
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
    private UserDao userDao;

    //private final UserQueryService userQueryService;

    @PostMapping("/createUser")
    public User createUserPOST(@RequestBody CreateUserDto userRequest) {
        return userDao.createNewUser(userRequest, userRequest.getIdAccount());
    }
    @GetMapping("/getAll")
    public String getAccountsGET() {
        return userDao.getAll();
    }
    @GetMapping("/get/{id}")
    public User getUserGET(@PathVariable String id) {
        return userDao.retrieveUserById(id);
    }
    @PatchMapping(value = "/email/{id}", consumes = MediaType.TEXT_PLAIN_VALUE)  //PATCH
    public boolean updateUserNameByIdPATCH(@PathVariable String id, @RequestBody String name) {
        return userDao.updateUserNameById(id, name);
    }
    @PatchMapping(value = "/delete/{id}")  //PATCH
    public boolean deleteUserByIdPATCH(@PathVariable String id) {
        return userDao.deleteUser(id);
    }
}
