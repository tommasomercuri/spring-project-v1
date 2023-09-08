package autoWiredV1.controller;

import autoWiredV1.model.dto.DataRequest;
import autoWiredV1.services.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class GeneralController {
    private final MapService mapService;
    @PostMapping("/create")
    public boolean createUserPOST(@RequestBody DataRequest dataRequest) {
        return mapService.putIntoLocalMap(dataRequest);
    }

    @GetMapping("/printMap")
    public String printMap(){
        return mapService.getAllMap();
    }
}
