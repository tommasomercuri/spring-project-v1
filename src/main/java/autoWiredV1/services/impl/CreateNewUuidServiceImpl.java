package autoWiredV1.services.impl;

import autoWiredV1.services.CreateNewUuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@Data
@NoArgsConstructor
public class CreateNewUuidServiceImpl implements CreateNewUuidService {
    @Override
    public String createNewUuid() {
        UUID uuid = UUID.randomUUID();
        System.out.println("NEW_UUID: "+uuid);
        return uuid.toString();
    }
}
