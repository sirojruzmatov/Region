package N3.Region.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "City")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
