package N3.Region.service.mapper;

import N3.Region.dto.VillageDto;
import N3.Region.entity.Village;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VillageMapper {

    Village toEntity(VillageDto villageDto);
    VillageDto toDto(Village village);
}
