package N3.Region.controller;

import N3.Region.dto.CityDto;
import N3.Region.dto.ResponseDto;
import N3.Region.service.Impl.CityServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //---> Shu class dan obyect olib continerga joylaydi
@RequestMapping("/city") //---> URL orqali yuboradi.
public class CityController {

    public final CityServiceImpl cityService;

    public CityController(CityServiceImpl cityService) {
        System.out.println("CityController created bean");
        this.cityService = cityService;
    }

    @PostMapping //create
    public ResponseDto addCity(@RequestBody CityDto cityDto){

        return cityService.addCity(cityDto);
    }

    @GetMapping //read
    public List<CityDto> getAll(){
        return cityService.getAll();
    }

    @PutMapping //update
    public ResponseDto updateCity(@RequestBody CityDto cityDto){
        return cityService.updateCity(cityDto);
    }

    @DeleteMapping("/{id}") //delete
    public ResponseDto deleteCity(@PathVariable Integer id){
        return cityService.deleteCity(id);
    }

}
