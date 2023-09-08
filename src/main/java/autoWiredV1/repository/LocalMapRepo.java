package autoWiredV1.repository;

import autoWiredV1.model.base.Account;
import autoWiredV1.model.base.User;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class LocalMapRepo  {
    @Getter
    private static Map<Account, User> createdKey = new HashMap<>();
}
