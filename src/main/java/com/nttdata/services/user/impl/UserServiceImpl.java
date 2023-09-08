package com.nttdata.services.user.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.base.User;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.services.user.UserService;
import com.nttdata.services.uuid.UuidService;
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
}
