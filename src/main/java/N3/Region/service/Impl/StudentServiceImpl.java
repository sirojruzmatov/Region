package N3.Region.service.Impl;

import N3.Region.dto.CityDto;
import N3.Region.dto.ResponseDto;
import N3.Region.entity.City;
import N3.Region.repository.CityRepository;
import N3.Region.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    public final CityRepository cityRepository;

    public StudentServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public ResponseDto addCity(CityDto cityDto) {
        City city = City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .build();
        cityRepository.save(city);

        return ResponseDto.builder()
                .code(0)
                .success(true)
                .message("Successfully create!")
                .build();
    }

    @Override
    public List<CityDto> getAll() {
       List<City> city = cityRepository.findAll();

       return  city.stream()
               .map(c -> CityDto.builder()
                       .id(c.getId())
                       .name(c.getName())
                       .build())
               .collect(Collectors.toList());
    }

    @Override
    public ResponseDto updateCity(CityDto cityDto) {

        City city = City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .build();

        cityRepository.save(city);

        return ResponseDto.builder()
                .code(-1)
                .success(true)
                .message("Data not found!")
                .build();
    }

    @Override
    public ResponseDto deleteCity(Integer id) {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);

            return ResponseDto.builder()
                    .code(0)
                    .success(true)
                    .message("Successfully deleted!")
                    .build();
        }
        return ResponseDto.builder()
                .code(-1)
                .success(false)
                .message("Data not found!")
                .build();
    }
}
