package autoWiredV1.services.impl;

import autoWiredV1.model.DataRequest;
import autoWiredV1.model.User;
import autoWiredV1.services.CreateNewUserService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Data
@NoArgsConstructor
public class CreateNewUserServiceImpl implements CreateNewUserService {
    @Override
    public User createNewUser( String name, String bornYear) {
        System.out.println(name);
        System.out.println(bornYear);
            User user = new User("", name, bornYear);
            System.out.println("Created new user:" + user.toString());
        return user;
    }

}
