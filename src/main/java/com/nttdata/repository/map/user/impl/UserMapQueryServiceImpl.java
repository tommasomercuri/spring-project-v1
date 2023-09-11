package com.nttdata.repository.map.user.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.map.user.UserMapRepo;
import com.nttdata.repository.UserQueryService;
import com.nttdata.services.uuid.UuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Data
@NoArgsConstructor
public class UserMapQueryServiceImpl implements UserQueryService {
    @Autowired
    UserMapRepo userMap;

    @Autowired
    UuidService uuidService;
    @Override
    public User createNewUser(CreateUserDto userRequest, String idAccount) {
        String id = uuidService.createNewUuid();

        //controllo esistenza e inserisco

        User user = new User(id, userRequest.getName(), userRequest.getBornYear(), idAccount);
        userMap.getMap().put(id,user);
        return user;
    }

    @Override
    public String getAllMap() {
        return userMap.getMap().toString();
    }

    @Override
    public User retrieveUserById(String id) {

        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean updateAccountEmail(Account account) {
        return false;
    }

    @Override
    public boolean updateAccountPassword(Account account) {
        return false;
    }

    @Override
    public boolean deleteUser(String id) {
        return false;
    }



}
