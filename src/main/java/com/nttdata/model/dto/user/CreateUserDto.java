package com.nttdata.model.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserDto {
    private String username;
    private String bornYear;
    private String idAccount;
}
