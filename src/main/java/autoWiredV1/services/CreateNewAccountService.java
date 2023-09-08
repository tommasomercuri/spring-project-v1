package autoWiredV1.services;


import autoWiredV1.model.Account;

public interface CreateNewAccountService {
    Account createNewAccount(String email, String password);

}
