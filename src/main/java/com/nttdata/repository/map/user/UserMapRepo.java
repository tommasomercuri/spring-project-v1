package com.nttdata.repository.map.user;

import com.nttdata.model.base.Account;
import com.nttdata.model.base.User;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Data
public class UserMapRepo {
    private Map<String, User> map ;
    public UserMapRepo(Map<String, User> map) {
        this.map = map;
    }

}

