package com.nttdata.controller;

import com.nttdata.model.dto.map.DataMapDto;
import com.nttdata.services.repository.map.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class GeneralController {
    private final MapService mapService;
    @PostMapping("/create")
    public boolean createAccountAndUserPOST(@RequestBody DataMapDto dataMapDto) {
        return mapService.putIntoLocalMap(dataMapDto);
    }

    @GetMapping("/printMap")
    public String printMap(){
        return mapService.getAllMap();
    }
}
