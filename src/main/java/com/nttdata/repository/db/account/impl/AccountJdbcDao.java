package com.nttdata.repository.db.account.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.repository.AccountCrud;
import com.nttdata.repository.db.account.AccountDaoInterface;
import com.nttdata.repository.db.account.AccountDetails;
import com.nttdata.repository.db.user.UserDetails;
import com.nttdata.service.uuid.UuidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class AccountJdbcDao implements AccountDaoInterface<AccountDetails>{

    @Autowired
    private UuidService uuidService;

    private JdbcTemplate jdbcTemplate;
    RowMapper<AccountDetails> rowMap = (result, num) -> {
        AccountDetails accounts = new AccountDetails();

        accounts.setIdAccount(result.getString("idAccount"));
        accounts.setEmail(result.getString("email"));
        accounts.setPassword(result.getString("password"));
        accounts.setCreatedAtDate(result.getDate("createdAtDate"));

        return accounts;
    };

    public AccountJdbcDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AccountDetails> list() {
        String query = "SELECT * FROM Account";
        return jdbcTemplate.query(query,rowMap);
    }

    @Override
    public Optional<AccountDetails> getById(String id) {
        String query = "SELECT * FROM Account WHERE idAccount = ?";
        AccountDetails account = null;

        try{
            account = jdbcTemplate.queryForObject(query, rowMap, id);
        }catch(DataAccessException dataAccessException){
            log.warn(dataAccessException.toString());
        }

        return Optional.ofNullable(account);
    }

    @Override
    public Optional<AccountDetails> addNewAccount(CreateAccountDto accountRequest) {
/*
        String insertQuery = "INSERT INTO Account (idAccount, email, password, createdAtDate) " +
                "values (?,?,?, CURRENT_TIME())";
        AccountDetails account = null;
        try{
            account = jdbcTemplate.queryForObject(insertQuery,rowMap,
                    uuidService.createNewUuid(),
                    accountRequest.getEmail(),
                    accountRequest.getPassword()
            );
        }catch(DataAccessException dataAccessException){
            log.warn(dataAccessException.toString());
        }
        return Optional.ofNullable(account);
*/
        return null;
    }

    @Override
    public void updateAccount(AccountDetails accountDetails) {

    }

}
