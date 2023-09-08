package autoWiredV1.services.impl;

import autoWiredV1.model.Account;
import autoWiredV1.model.DataRequest;
import autoWiredV1.services.CreateNewAccountService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreateNewAccountServiceImpl implements CreateNewAccountService {
    DataRequest dataRequest ;
    @Override
    public Account createNewAccount(String email, String password) {
            Date date = new Date();
        System.out.println(date.toString());
        System.out.println(email.toString());
        System.out.println(password.toString());
            Account account = new Account("" , email, password, date);
            //dataRequest.setAccount(account);
            System.out.println("Created new account:" + account.toString());
        return account;
    }

}
