package N3.Region.controller;

import N3.Region.dto.PersonDto;
import N3.Region.dto.ResponseDto;
import N3.Region.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseDto<String> addPerson(@RequestBody PersonDto personDto){
        return personService.addPerson(personDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto<PersonDto> deletePerson(@PathVariable Integer id){
        return personService.deletePerson(id);
    }

    @GetMapping("/{id}")
    public ResponseDto<PersonDto> findById(@PathVariable Integer id){
        return personService.findById(id);
    }
}
