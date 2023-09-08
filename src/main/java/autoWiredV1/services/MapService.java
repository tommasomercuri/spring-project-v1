package autoWiredV1.services;

import autoWiredV1.model.dto.DataRequest;

public interface MapService {
    String getAllMap();
    boolean putIntoLocalMap(DataRequest dataRequest);

}
