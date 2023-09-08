package autoWiredV1.services.impl;

import autoWiredV1.model.Account;
import autoWiredV1.model.DataRequest;
import autoWiredV1.services.CreateNewAccountService;
import autoWiredV1.services.CreateNewUserService;
import autoWiredV1.services.CreateNewUuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class CreateNewAccountServiceImpl implements CreateNewAccountService {
    @Autowired
    CreateNewUuidService createNewUuidService;
    @Override
    public Account createNewAccount(String email, String password) {
            Date date = new Date();
            Account account = new Account( createNewUuidService.createNewUuid(), email, password, date);
            System.out.println("Created new account:" + account.toString());
        return account;
    }

}
