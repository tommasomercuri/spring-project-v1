package com.nttdata.repository.db.user.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.repository.AccountCrud;
import com.nttdata.repository.db.user.UserDaoInterface;
import com.nttdata.repository.db.user.UserDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserJdbcDao implements UserDaoInterface<UserDetails>, AccountCrud {

    private JdbcTemplate jdbcTemplate;

    RowMapper<UserDetails> rowMap = (result, num) -> {

        UserDetails users = new UserDetails();

        users.setIdUser(result.getString("idUser"));
        users.setUsername(result.getString("username"));
        users.setBornYear(result.getInt("bornYear"));
        users.setIdAccount(result.getString("idAccount"));

        return users;
    };

    public UserJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<UserDetails> list() {
        String query = "SELECT * FROM User";
        return jdbcTemplate.query(query, rowMap);
    }

    @Override
    public Account insertNewAccount(CreateAccountDto accountRequest) {
        return null;
    }

    @Override
    public Account retrieveAccountById(String id) {
        return null;
    }

    @Override
    public boolean updateAccountEmailById(String id, String email) {
        return false;
    }

    @Override
    public boolean updateAccountPasswordById(String id, String password) {
        return false;
    }

    @Override
    public boolean deleteAccountById(String id) {
        return false;
    }

    @Override
    public String getAll() {
        return null;
    }

    @Override
    public boolean checkIfAccountExistById(String id) {
        return false;
    }
}
