package com.nttdata.model.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateAccountDto {
    private String email;
    private String password;
}



