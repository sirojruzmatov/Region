package N3.Region.service.Impl;

import N3.Region.components.StringHelper;
import N3.Region.dto.CityDto;
import N3.Region.dto.PersonDto;
import N3.Region.dto.ResponseDto;
import N3.Region.entity.City;
import N3.Region.repository.CityRepository;
import N3.Region.service.CityService;
import N3.Region.service.mapper.CityCustomMapper;
import N3.Region.service.mapper.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Lazy(value = false)
@Service
@RequiredArgsConstructor //final bo'lgan fildlar uchun constructor yasab beradi.

//@NoArgsConstructor -- parametrsiz bo'sh constructor ochib beradi
//@AllArgsConstructor -- hamma parametrlarni ishlatib constructor ochib beradi.

public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final StringHelper stringHelper;
    private final PersonDto Siroj;
    private final Connection dev;

    private final CityMapper cityMapper;

    @PostConstruct // init() method
    public void init() throws SQLException {
        System.out.println("Initialized service bean");
        System.out.println(Siroj);
        System.out.println(dev.getSchema());

        // Bean yaratilib bo'lgandan keyin mana shu yerda nima method
        // yozsak shu method ishlaydi
    }

    @PreDestroy //destroy() method
    public void destroy(){
        System.out.println("Destroyed service bean");

        // Bu yerda yozilgan method lar dastur ishdan
        // to'xtayotganda ishlaydi
        //Masalan:
        System.out.println("Dastur ishdan to'xtadi");
    }

    @Override
    public ResponseDto addCity(CityDto cityDto) {
        City city = cityMapper.toEntity(cityDto);
        cityRepository.save(city);

        return ResponseDto.builder()
                .code(0)
                .success(true)
                .message("Successfully create!")
                .data(city)
                .build();
    }

    @Override
    public List<CityDto> getAll() {
       List<City> cityList = cityRepository.findAll(); //finAll() --> list qilib olib beradi.

       List<CityDto> cityDtos = cityList.stream()
               .map(CityCustomMapper::toDto)
               .toList();
       return cityDtos;
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
