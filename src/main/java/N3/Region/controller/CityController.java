package N3.Region.controller;

import N3.Region.dto.CityDto;
import N3.Region.dto.ResponseDto;
import N3.Region.service.Impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    public final StudentServiceImpl studentService;

    public CityController(StudentServiceImpl studentService) {

        this.studentService = studentService;
    }

    @PostMapping //create
    public ResponseDto addCity(@RequestBody CityDto cityDto){

        return studentService.addCity(cityDto);
    }

    @GetMapping //read
    public List<CityDto> getAll(){
        return studentService.getAll();
    }

    @PutMapping //update
    public ResponseDto updateCity(@RequestBody CityDto cityDto){
        return studentService.updateCity(cityDto);
    }

    @DeleteMapping("/{id}") //delete
    public ResponseDto deleteCity(@PathVariable Integer id){
        return studentService.deleteCity(id);
    }

}
