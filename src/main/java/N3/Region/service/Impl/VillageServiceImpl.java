package N3.Region.service.Impl;

import N3.Region.dto.ResponseDto;
import N3.Region.dto.VillageDto;
import N3.Region.entity.Village;
import N3.Region.repository.VillageRepository;
import N3.Region.service.VillageService;
import N3.Region.service.mapper.VillageCustomMapper;
import N3.Region.service.mapper.VillageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VillageServiceImpl implements VillageService {

    private final VillageRepository villageRepository;
    private final VillageMapper villageMapper;

    //@Mapper(componentModel = "spring")
    public VillageServiceImpl(VillageRepository villageRepository, VillageMapper villageMappe) {
        this.villageRepository = villageRepository;
        this.villageMapper = villageMappe;
    }

// componentModel = default holatidagi:-->
//    public VillageServiceImpl(VillageRepository villageRepository) {
//        this.villageRepository = villageRepository;
//        villageMapper = Mappers.getMapper(VillageMapper.class);
//    }

    @Override
    public ResponseDto addVillage(VillageDto dto) {
        try {
            Village village = villageRepository.save(villageMapper.toEntity(dto));
            return ResponseDto.<VillageDto>builder().code(0).success(true).message("Successfully save!").data(villageMapper.toDto(village)).build();
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseDto.<String>builder().code(-1).success(false).message(e.getMessage()).build();
        }
    }

    @Override
    public ResponseDto<VillageDto> findById(Integer id){
        try{
            Optional<Village> villageOptional = villageRepository.findById(id);
            if (villageOptional.isEmpty()){
                return ResponseDto.<VillageDto>builder().code(-1).success(false).message("Data not found").build();
            }

            Village village = villageOptional.get();
            VillageDto villageDto = VillageCustomMapper.toDto(village);

            return ResponseDto.<VillageDto>builder().code(0).success(true).data(villageDto).message("OK").build();

        }catch (Exception e){
            return ResponseDto.<VillageDto>builder().code(-1).success(false).message(e.getMessage()).build();
        }
    }

    @Override
    public ResponseDto<List<VillageDto>> findAll(){
        List<Village> villageList = villageRepository.findAll();

        List<VillageDto> villageDtos = villageList.stream()
                .map(VillageCustomMapper::toDto)
                .collect(Collectors.toList());

        return ResponseDto.<List<VillageDto>>builder().code(0).success(true).data(villageDtos).message("OK").build();
    }


    @Override
    public ResponseDto deleteVillage(Integer id) {
        if (villageRepository.existsById(id)) {
            villageRepository.deleteById(id);

            return ResponseDto.builder().code(0).success(true).message("Successfully deleted!").build();
        }
        return ResponseDto.builder().code(-1).success(false).message("Data not found!").build();
    }
}
