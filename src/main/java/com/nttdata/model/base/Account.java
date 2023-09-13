package com.nttdata.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    private String idAccount;
    private String email;
    private String password;
    private Date createdAtDate;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account(String idAccount) {
        this.idAccount = idAccount;
    }
}
