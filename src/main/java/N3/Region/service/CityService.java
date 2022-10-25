package N3.Region.service;

import N3.Region.dto.CityDto;
import N3.Region.dto.ResponseDto;

import java.util.List;

public interface CityService {

    ResponseDto addCity(CityDto cityDto);

    List<CityDto> getAll();

    ResponseDto updateCity(CityDto cityDto);

    ResponseDto deleteCity(Integer id);

}
