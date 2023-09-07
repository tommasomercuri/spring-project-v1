package autoWiredV1.model;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private int bornYear;

    @Autowired
    //@Resource(name="accountBean2")
    //@Qualifier("accountBean2")
    private Account account;
    
    public User(Account acc){
        this.account = acc;
    }

    public void callAcc(){
        System.out.println(account.toString());
    }
}
