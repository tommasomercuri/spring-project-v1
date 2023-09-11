package com.nttdata.repository.map.account;

import com.nttdata.model.base.Account;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Data
public class AccountMapRepo {
    private Map<String, Account> map ;
    public AccountMapRepo(Map<String, Account> map) {
        this.map = map;
    }
}
