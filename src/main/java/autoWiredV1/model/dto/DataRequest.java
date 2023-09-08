package autoWiredV1.model.dto;

import autoWiredV1.model.base.Account;
import autoWiredV1.model.base.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataRequest {
    //@JsonProperty("Account")
    private AccountDto account;
    private User user;
}
