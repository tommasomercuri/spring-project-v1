package com.nttdata.repository.map.user.impl;

import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.AccountQueryService;
import com.nttdata.repository.map.account.AccountMapRepo;
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
    AccountMapRepo accountMapRepo;
    @Autowired
    UserMapRepo userMap;
    @Autowired
    AccountQueryService accountQueryService;

    @Autowired
    UuidService uuidService;
    @Override
    public User createNewUser(CreateUserDto userRequest, String idAccount) {
        if(!accountQueryService.checkIfAccountExistById(idAccount)){
            throw new IllegalArgumentException("Id account does not exist");
        }
        String id = uuidService.createNewUuid();
        User user = new User(id, userRequest.getUsername(), userRequest.getBornYear(), idAccount);
        userMap.getMap().put(id,user);
        return user;
    }

    @Override
    public String getAll() {
        return userMap.getMap().toString();
    }

    @Override
    public User retrieveUserById(String id) {
        return userMap.getMap().get(id);
    }

    @Override
    public boolean updateUserNameById(String id, String name) {
        userMap.getMap().get(id).setUsername(name);
        return true;
    }

    @Override
    public boolean deleteUser(String id) {
        userMap.getMap().remove(id);
        return true;
    }


}
