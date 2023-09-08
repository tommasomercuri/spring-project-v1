package com.nttdata.services.repository.map.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.base.User;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.model.dto.map.DataMapDto;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.MapRepo;
import com.nttdata.services.repository.AccountQueryService;
import com.nttdata.services.repository.UserQueryService;
import com.nttdata.services.repository.map.MapService;
import com.nttdata.services.uuid.UuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@Service
@Component
@Data
@NoArgsConstructor
public class UserMapQueryServiceImpl implements UserQueryService {
    Map<Account, User> createdKey = MapRepo.getCreatedKey();
    private User user;
    @Autowired
    UuidService uuidService;
    @Override
    public User createNewUser(CreateUserDto userRequest) {
        User user = new User(uuidService.createNewUuid(), userRequest.getName(), userRequest.getBornYear());
        System.out.println("Created new user:" + user.toString());
        return user;
    }

    @Override
    public User retrieveUserById(String id) {
        /*
        Set<Account> acc = createdKey.keySet();
        for (Account ac : acc){
            System.out.println(ac.toString());
        }
         */
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
