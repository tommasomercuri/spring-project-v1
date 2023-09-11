package com.nttdata.repository.map.user;

import com.nttdata.model.dto.map.DataMapDto;

public interface UserMapService {
    boolean putIntoLocalMap(DataMapDto dataMapDto, String idAccount);

}
