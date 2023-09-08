package autoWiredV1.repository;

import autoWiredV1.model.Account;
import autoWiredV1.model.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class LocalMapRepo  {
    @Getter
    private static Map<Account, User> createdKey = new HashMap<>();
}
