package autoWiredV1.services.impl;

import autoWiredV1.model.base.Account;
import autoWiredV1.model.base.User;
import autoWiredV1.model.dto.DataRequest;
import autoWiredV1.repository.LocalMapRepo;
import autoWiredV1.services.AccountService;
import autoWiredV1.services.UserService;
import autoWiredV1.services.MapService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
@Data
@NoArgsConstructor
public class MapServiceImpl implements MapService {
    Map<Account, User> createdKey = LocalMapRepo.getCreatedKey();
    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;
    @Override
    public String getAllMap() {
        return createdKey.toString();
    }
    @Override
    public boolean putIntoLocalMap(DataRequest dataRequest) {
        createdKey.put(
            accountService.createNewAccount(
                    dataRequest.getAccount().getEmail(),
                    dataRequest.getAccount().getPassword()
            ),
            userService.createNewUser(
                    dataRequest.getUser().getName(),
                    dataRequest.getUser().getBornYear()
            )
        );
        System.out.println("Added "+dataRequest.getClass()+" to "+ createdKey.getClass());
        return true;
    }

}
