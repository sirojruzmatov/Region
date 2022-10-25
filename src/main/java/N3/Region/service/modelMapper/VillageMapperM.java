package N3.Region.service.modelMapper;

import N3.Region.dto.VillageDto;
import N3.Region.entity.Village;
import N3.Region.repository.VillageRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class VillageMapperM {
    private final ModelMapper mapper;

    public Village toEntity(VillageDto villageDto){
        return mapper.map(villageDto, Village.class);
    }
    
    public VillageDto toDto(Village village){
        return mapper.map(village, VillageDto.class);
    }
}
