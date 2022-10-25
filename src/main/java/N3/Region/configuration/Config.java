package N3.Region.configuration;

import N3.Region.dto.CityDto;
import N3.Region.dto.PersonDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Configuration //--> bu anatatsiya qo'yilgan class ni ichida biz bean larni hosil qilsak bo'ladi.
// ya'ni biz yozgan method dan qaytgan javob bizga bean bo'lib qaytadi. Nechta method yozsak shuncha bean
//hosil bo'ladi.
public class Config {

    @Bean
    public PersonDto Siroj() throws ParseException {
        return PersonDto.builder()
                .id(1)
                .firstName("Siroj")
                .lastName("Ro'zmatov")
                .age(25)
                .birthDate(new SimpleDateFormat("dd-MM-yyyy").parse("10-03-1997"))
                .build();
    }

    @Bean(name = "dev")
    public Connection dev() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/dev",
                "postgres",
                "siroj97");
    }

    @Bean(name = "student")
    public Connection student() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/student",
                "postgres",
                "siroj97");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
