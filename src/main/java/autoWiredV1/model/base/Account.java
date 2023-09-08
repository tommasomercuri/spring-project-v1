package autoWiredV1.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
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
}
