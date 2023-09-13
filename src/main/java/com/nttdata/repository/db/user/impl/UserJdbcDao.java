package com.nttdata.repository.db.user.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.AccountCrud;
import com.nttdata.repository.db.user.UserDaoInterface;
import com.nttdata.repository.db.user.UserDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserJdbcDao implements UserDaoInterface<UserDetails>{

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
    public Optional<UserDetails> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDetails> addNewUser(CreateUserDto createUserDto) {
        return Optional.empty();
    }

    @Override
    public void updateAccount(UserDetails userDetails) {

    }

}
