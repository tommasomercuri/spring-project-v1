package com.nttdata.model.dto.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateAccountEmailByIdDto {
    String id;
    String email;
}
