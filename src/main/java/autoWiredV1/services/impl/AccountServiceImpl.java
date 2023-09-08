package autoWiredV1.services.impl;

import autoWiredV1.model.base.Account;
import autoWiredV1.services.AccountService;
import autoWiredV1.services.UuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class AccountServiceImpl implements AccountService {
    @Autowired
    UuidService uuidService;

    @Override
    public Account createNewAccount(String email, String password) {
            Date date = new Date();
            Account account = new Account( uuidService.createNewUuid(), email, password, date);
            System.out.println("Created new account:" + account.toString());
        return account;
    }

    @Override
    public Account retrieveAccountById(String id) {
        return null;
    }

    @Override
    public boolean updateAccount(Account account) {
        return false;
    }
        @Override
        public boolean updateAccountEmailById(String id) {
            return false;
        }
        @Override
        public boolean updateAccountPasswordById(String id) {
            return false;
        }
    @Override
    public boolean deleteAccount(String id) {
        return false;
    }




}
