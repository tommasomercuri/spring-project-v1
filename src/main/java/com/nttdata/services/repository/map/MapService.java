package com.nttdata.services.repository.map;

import com.nttdata.model.dto.map.DataMapDto;

public interface MapService {
    String getAllMap();
    boolean putIntoLocalMap(DataMapDto dataMapDto);

}
