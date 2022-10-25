package N3.Region.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data //---> class ga getter va setter qo'yib beradi
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {  //City ma'lumotlari

    private Integer id;
    private String name;
    private List<VillageDto> villages;

    public String toString() {
        return "City id : " + id + "\n" +
                "City name : " + name + "\n";
    }

}
