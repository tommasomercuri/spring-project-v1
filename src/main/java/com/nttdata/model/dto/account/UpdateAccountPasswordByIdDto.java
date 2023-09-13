package com.nttdata.model.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateAccountPasswordByIdDto {
    String id;
    String password;
}
