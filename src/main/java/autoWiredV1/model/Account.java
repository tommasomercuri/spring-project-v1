package autoWiredV1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {
    private String idAccount;
    private String email;
    private String password;
    private Date createdAtDate;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
