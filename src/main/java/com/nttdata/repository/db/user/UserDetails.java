package com.nttdata.repository.db.user;

import com.nttdata.model.base.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("UserDetails")
public class UserDetails {
    @Id
    @Column("idUser")
    private String idUser;
    @Column("username")
    private String username;
    @Column("bornYear")
    private int bornYear;
    @Column("idAccount")
    private String idAccount;

    static UserDetails create(String idUser, String username, int bornYear, String idAccount){
        return new UserDetails(idUser,username,bornYear,idAccount);
    }

}
