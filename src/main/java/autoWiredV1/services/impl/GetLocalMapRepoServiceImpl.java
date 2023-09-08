package autoWiredV1.services.impl;

import autoWiredV1.model.Account;
import autoWiredV1.model.User;
import autoWiredV1.repository.LocalMapRepo;
import autoWiredV1.services.GetLocalMapRepoService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@NoArgsConstructor
public class GetLocalMapRepoServiceImpl implements GetLocalMapRepoService {
    @Override
    public String getMap() {
        return LocalMapRepo.getCreatedKey().toString();
    }
}
