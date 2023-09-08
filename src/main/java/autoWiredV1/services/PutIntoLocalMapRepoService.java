package autoWiredV1.services;

import autoWiredV1.model.Account;
import autoWiredV1.model.User;

public interface PutIntoLocalMapRepoService  {
    public boolean putIntoLocalMap(Account account, User user);
}
