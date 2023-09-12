package com.nttdata.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private String idUser;
    private String username;
    private String bornYear;
    private String idAccount;

}
