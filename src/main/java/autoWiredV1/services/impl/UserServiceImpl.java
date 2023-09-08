package autoWiredV1.services.impl;

import autoWiredV1.model.base.Account;
import autoWiredV1.model.base.User;
import autoWiredV1.services.UserService;
import autoWiredV1.services.UuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Data
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    UuidService uuidService;
    @Override
    public User createNewUser( String name, String bornYear) {
            User user = new User(uuidService.createNewUuid(), name, bornYear);
            System.out.println("Created new user:" + user.toString());
        return user;
    }

    @Override
    public Account retrieveUserBy(String id) {
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean updateAccountEmail(Account account) {
        return false;
    }

    @Override
    public boolean updateAccountPassword(Account account) {
        return false;
    }

    @Override
    public boolean deleteAccount(String id) {
        return false;
    }

}
