package autoWiredV1.services;

import autoWiredV1.model.Account;
import autoWiredV1.model.User;

public interface CreateNewUserService {
    User createNewUser(String name, String bornYear);
}
