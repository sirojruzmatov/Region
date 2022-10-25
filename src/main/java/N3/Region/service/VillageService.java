package N3.Region.service;

import N3.Region.dto.ResponseDto;
import N3.Region.dto.VillageDto;

import java.util.List;

public interface VillageService {

    ResponseDto addVillage(VillageDto villageDto);

    ResponseDto<VillageDto> findById(Integer id);

    ResponseDto<List<VillageDto>> findAll();

    ResponseDto deleteVillage(Integer id);
}
