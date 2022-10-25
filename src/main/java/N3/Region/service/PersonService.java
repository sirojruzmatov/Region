package N3.Region.service;

import N3.Region.dto.PersonDto;
import N3.Region.dto.ResponseDto;

import java.util.List;

public interface PersonService {
    ResponseDto<String> addPerson(PersonDto personDto);

    ResponseDto deletePerson(Integer id);

    ResponseDto<PersonDto> findById(Integer id);
}
