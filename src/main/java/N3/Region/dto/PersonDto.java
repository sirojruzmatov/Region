package N3.Region.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthDate;

    private VillageDto village;

    public String toString() {
        return "Person id : " + id + "\n" +
                "Person firstName : " + firstName + "\n"+
                "Person lastName : " + lastName + "\n"+
                "Person age : " + age + "\n"+
                "Person birthDate : " + birthDate + "\n";
    }

}
