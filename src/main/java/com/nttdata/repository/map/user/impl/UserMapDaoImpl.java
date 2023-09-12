package com.nttdata.repository.map.user.impl;

import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.AccountDao;
import com.nttdata.repository.map.account.AccountMapRepo;
import com.nttdata.repository.map.user.UserMapRepo;
import com.nttdata.repository.UserDao;
import com.nttdata.service.uuid.UuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Component
@Data
@NoArgsConstructor
@Repository("userMap")
public class UserMapDaoImpl implements UserDao {
    @Autowired
    AccountMapRepo accountMapRepo;
    @Autowired
    UserMapRepo userMap;
    @Autowired
    UuidService uuidService;

    @Autowired
    @Qualifier("accountMap")
    private AccountDao accountDao;
    //Non utilizzo constructor Injection per Qualifier
       //private final AccountQueryService accountQueryService;

    @Override
    public User createNewUser(CreateUserDto userRequest, String idAccount) {
        if(!accountDao.checkIfAccountExistById(idAccount)){
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
