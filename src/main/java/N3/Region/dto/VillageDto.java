package N3.Region.dto;

import N3.Region.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VillageDto {

    private Integer id;
    private String name;
    private List<PersonDto> personId;
    private CityDto city;
}
