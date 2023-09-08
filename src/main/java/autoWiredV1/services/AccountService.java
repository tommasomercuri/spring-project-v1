package autoWiredV1.services;


import autoWiredV1.model.base.Account;

public interface AccountService {
    Account createNewAccount(String email, String password);
    Account retrieveAccountById(String id);
    boolean updateAccount(Account account);
        boolean updateAccountEmailById(String id);
        boolean updateAccountPasswordById(String id);
    boolean deleteAccount(String id);



}
