package autoWiredV1.services;

import autoWiredV1.model.base.Account;
import autoWiredV1.model.base.User;

public interface UserService {
    User createNewUser(String name, String bornYear);
    Account retrieveUserBy(String id);
    boolean updateUser(User user);
        boolean updateAccountEmail(Account account);
        boolean updateAccountPassword(Account account);
    boolean deleteAccount(String id);

}
