package autoWiredV1.controller;

import autoWiredV1.model.base.User;
import autoWiredV1.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @PostMapping("/createUser")
    public String createUserPOST(@RequestBody User userRequest) {
        return (
                userService.createNewUser(
                        userRequest.getName(),
                        userRequest.getBornYear()
                )
        ).toString();
    }
}
