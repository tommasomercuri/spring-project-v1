package autoWiredV1.services.impl;

import autoWiredV1.model.Account;
import autoWiredV1.model.User;
import autoWiredV1.repository.LocalMapRepo;
import autoWiredV1.services.CreateNewAccountService;
import autoWiredV1.services.CreateNewUserService;
import autoWiredV1.services.PutIntoLocalMapRepoService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
@Data
@NoArgsConstructor
public class PutIntoLocalMapRepoServiceImpl implements PutIntoLocalMapRepoService {
    Map<Account, User> createdKey = LocalMapRepo.getCreatedKey();
    @Autowired
    CreateNewAccountService createNewAccountService;
    @Autowired
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
