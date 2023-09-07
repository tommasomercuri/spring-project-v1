package autoWiredV1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private String id;
    private String email;
    private String password;
    private String createdAtDate;

    public Account() {
        System.out.println("Account Created");
    }
}
