package com.nttdata.repository.db.user.impl;

import com.nttdata.model.base.Account;
import com.nttdata.model.base.User;
import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.model.dto.user.CreateUserDto;
import com.nttdata.repository.AccountCrud;
import com.nttdata.repository.db.account.AccountDetails;
import com.nttdata.repository.db.user.UserDaoInterface;
import com.nttdata.repository.db.user.UserDetails;
import com.nttdata.service.uuid.UuidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class UserJdbcDao implements UserDaoInterface<UserDetails>{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    UuidService uuidService;


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
        String query = "SELECT * FROM User WHERE idUser = ?";
        UserDetails user = null;

        try{
            user = jdbcTemplate.queryForObject(query, rowMap, id);
        }catch(DataAccessException dataAccessException){
            log.warn(dataAccessException.toString());
        }

        return Optional.ofNullable(user);
    }

    public User addNewUser(CreateUserDto userRequest) {
        String insertQuery = "INSERT INTO User (idUser, username, bornYear, idAccount) " +
                "values (?,?,?,?)";

        String uuid = uuidService.createNewUuid();

        jdbcTemplate.update(insertQuery,
                uuid,
                userRequest.getUsername(),
                userRequest.getBornYear(),
                userRequest.getIdAccount()
        );
        Date date = new Date();
        return new User(uuid, userRequest.getUsername(), userRequest.getBornYear(), userRequest.getIdAccount()
        );
    }
    @Override
    public void updateAccount(UserDetails userDetails) {

    }

}
