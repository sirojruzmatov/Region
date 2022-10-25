package N3.Region.service.mapper;

import N3.Region.dto.CityDto;
import N3.Region.dto.VillageDto;
import N3.Region.entity.City;

import java.util.List;
import java.util.stream.Collectors;

public class CityCustomMapper {

    public static CityDto toWithoutListVillageDto(City city){
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }

    public static CityDto toDto(City city){
        List<VillageDto> villageDtos = city.getVillages()
                .stream()
                .map(VillageCustomMapper::toWithoutCity)
                .collect(Collectors.toList());

        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .villages(villageDtos)
                .build();
    }
}
