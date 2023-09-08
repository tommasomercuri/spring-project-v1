package com.nttdata.model.dto.map;

import com.nttdata.model.dto.account.CreateAccountDto;
import com.nttdata.model.dto.user.CreateUserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataMapDto {
    //@JsonProperty("Account")
    private CreateAccountDto account;
    private CreateUserDto user;
}
