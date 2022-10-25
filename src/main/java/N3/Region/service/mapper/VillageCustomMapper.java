package N3.Region.service.mapper;

import N3.Region.dto.CityDto;
import N3.Region.dto.PersonDto;
import N3.Region.dto.VillageDto; //Agar Get method ni Village orqali ishlatsak CityDto null bo'lishi k-k
import N3.Region.entity.Village;

import java.util.List;
import java.util.stream.Collectors;

public class VillageCustomMapper {

    public static VillageDto toDto(Village village){
        return VillageDto.builder()
                .id(village.getId())
                .name(village.getName())
                .personId(village.getPersonList().stream()
                        .map(PersonCustomMapper::toWithoutVillageDto).collect(Collectors.toList())
                )
                .city(CityCustomMapper.toWithoutListVillageDto(village.getCity()))
                .build();
    }

    public static VillageDto toWithoutCity(Village village){
        return VillageDto.builder()
                .id(village.getId())
                .name(village.getName())
                .personId(village.getPersonList().stream()
                        .map(PersonCustomMapper::toWithoutVillageDto).collect(Collectors.toList()))
                .build();

    }

    public static VillageDto toDtoPer(Village village){
        List<PersonDto> personDtos = village.getPersonList()
                .stream()
                .map(PersonCustomMapper::toWithoutVillageDto)
                .collect(Collectors.toList());

        return VillageDto.builder()
                .id(village.getId())
                .name(village.getName())
                .personId(personDtos)
                .build();
    }

    public static VillageDto toWithoutListPerson(Village village){
        return VillageDto.builder()
                .id(village.getId())
                .name(village.getName())
                .build();

    }

    public static Village toEntity(VillageDto villageDto){
        return null;
    }
}
