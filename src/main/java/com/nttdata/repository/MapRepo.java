package com.nttdata.repository;

import com.nttdata.model.base.Account;
import com.nttdata.model.base.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class MapRepo {
    @Getter
    private static Map<Account, User> createdKey = new HashMap<>();
}
