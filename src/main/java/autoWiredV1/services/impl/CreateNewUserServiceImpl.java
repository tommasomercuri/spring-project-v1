package autoWiredV1.services.impl;

import autoWiredV1.model.DataRequest;
import autoWiredV1.model.User;
import autoWiredV1.services.CreateNewUserService;
import autoWiredV1.services.CreateNewUuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Data
@NoArgsConstructor
public class CreateNewUserServiceImpl implements CreateNewUserService {
    @Autowired
    CreateNewUuidService createNewUuidService;
    @Override
    public User createNewUser( String name, String bornYear) {
        System.out.println(name);
        System.out.println(bornYear);
            User user = new User(createNewUuidService.createNewUuid(), name, bornYear);
            System.out.println("Created new user:" + user.toString());
        return user;
    }

}
