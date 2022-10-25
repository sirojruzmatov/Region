package N3.Region.service.mapper;

import N3.Region.dto.PersonDto;
import N3.Region.dto.VillageDto;
import N3.Region.entity.Person;

public class PersonCustomMapper {

    public static PersonDto toWithoutVillageDto(Person person){
        return PersonDto.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .age(person.getAge())
                .birthDate(person.getBirthDate())
                .build();
    }

    public static PersonDto toDtoVil(Person person){
        return PersonDto.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .age(person.getAge())
                .birthDate(person.getBirthDate())
                .village(VillageCustomMapper.toWithoutListPerson(person.getVillage()))
                .build();
    }

}
