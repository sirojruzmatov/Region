package N3.Region.controller;

import N3.Region.dto.ResponseDto;
import N3.Region.dto.VillageDto;
import N3.Region.service.VillageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/village")
@RequiredArgsConstructor
public class VillageController {

    private final VillageService villageService;

    @PostMapping
    public ResponseDto addVillage(@RequestBody VillageDto villageDto){
        return villageService.addVillage(villageDto);
    }

    @GetMapping("/{id}")
    public ResponseDto<VillageDto> findById( @PathVariable Integer id){
        return villageService.findById(id);
    }

    @GetMapping
    public ResponseDto<List<VillageDto>> findAll(){
        return villageService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseDto<VillageDto> deleteVillage(@PathVariable Integer id){
        return villageService.deleteVillage(id);
    }
}
