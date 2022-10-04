package N3.Region.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDto {

    private Integer id;
    private String name;

    public String toString() {
        return "City id : " + id + "\n" +
                "City name : " + name + "\n";
    }

}
