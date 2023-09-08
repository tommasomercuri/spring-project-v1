package com.nttdata.services.repository.map.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.base.User;
import com.nttdata.model.dto.map.DataMapDto;
import com.nttdata.repository.MapRepo;
import com.nttdata.services.account.AccountService;
import com.nttdata.services.repository.AccountQueryService;
import com.nttdata.services.repository.UserQueryService;
import com.nttdata.services.user.UserService;
import com.nttdata.services.repository.map.MapService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
@Data
@NoArgsConstructor
public class MapServiceImpl implements MapService {
    Map<Account, User> createdKey = MapRepo.getCreatedKey();
    @Autowired
    AccountQueryService accountQueryService;
    @Autowired
    UserQueryService userQueryService;
    @Override
    public String getAllMap() {
        return createdKey.toString();
    }
    @Override
    public boolean putIntoLocalMap(DataMapDto dataMapDto) {
        createdKey.put(
            accountQueryService.createNewAccount(
                    dataMapDto.getAccount()
            ),
            userQueryService.createNewUser(
                    dataMapDto.getUser()
            )
        );
        System.out.println("Added "+ dataMapDto.getClass()+" to "+ createdKey.getClass());
        return true;
    }

}
