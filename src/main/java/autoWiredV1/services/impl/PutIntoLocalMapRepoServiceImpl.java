package autoWiredV1.services.impl;

import autoWiredV1.model.Account;
import autoWiredV1.model.User;
import autoWiredV1.repository.LocalMapRepo;
import autoWiredV1.services.CreateNewAccountService;
import autoWiredV1.services.CreateNewUserService;
import autoWiredV1.services.PutIntoLocalMapRepoService;

import java.util.Map;

public class PutIntoLocalMapRepoServiceImpl implements PutIntoLocalMapRepoService {
    Map<Account, User> createdKey = LocalMapRepo.getCreatedKey();
    CreateNewAccountService createNewAccountService;
    CreateNewUserService createNewUserService;

    @Override
    public boolean putIntoLocalMap(Account account, User user) {
        createdKey.put(
                createNewAccountService.createNewAccount(
                        account.getEmail(),
                        account.getPassword()),
                createNewUserService.createNewUser(
                        user.getName(),
                        user.getBornYear()
                )
        );
        return true;
    }

}
