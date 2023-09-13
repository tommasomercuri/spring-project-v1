package com.nttdata.repository.db.account;

import com.nttdata.model.base.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("AccountDetails")
public class AccountDetails {
    @Id
    @Column("idAccount")
    private String idAccount;
    @Column("email")
    private String email;
    @Column("password")
    private String password;
    @Column("createdAtDate")
    private Date createdAtDate;
    static AccountDetails create(String idAccount, String email, String password, Date createdAtDate){
        return new AccountDetails(idAccount,email,password,createdAtDate);
    }

    public AccountDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
