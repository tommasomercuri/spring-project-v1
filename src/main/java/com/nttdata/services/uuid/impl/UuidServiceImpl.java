package com.nttdata.services.uuid.impl;

import com.nttdata.services.uuid.UuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@Data
@NoArgsConstructor
public class UuidServiceImpl implements UuidService {
    @Override
    public String createNewUuid() {
        UUID uuid = UUID.randomUUID();
        System.out.println("NEW_UUID: "+uuid);
        return uuid.toString();
    }
}
