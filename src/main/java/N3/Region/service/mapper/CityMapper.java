package N3.Region.service.mapper;

import N3.Region.dto.CityDto;
import N3.Region.entity.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City toEntity(CityDto cityDto);

    CityDto toDto (City city);
}
