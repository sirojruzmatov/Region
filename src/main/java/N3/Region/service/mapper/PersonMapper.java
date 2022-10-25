package N3.Region.service.mapper;

import N3.Region.dto.PersonDto;
import N3.Region.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person toEntity(PersonDto personDto);

    PersonDto toDto(Person person);
}
