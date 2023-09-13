package com.nttdata.service.uuid.impl;

import com.nttdata.service.uuid.UuidService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Slf4j
@Component
@Data
@NoArgsConstructor
public class UuidServiceImpl implements UuidService {
    @Override
    public String createNewUuid() {
        UUID uuid = UUID.randomUUID();
        log.warn("NEW_UUID: "+uuid);
        return uuid.toString();
    }
}
