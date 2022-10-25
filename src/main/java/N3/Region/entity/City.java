package N3.Region.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.boot.model.relational.Sequence;

import javax.persistence.*;
import java.util.List;

import static org.hibernate.id.SequenceGenerator.SEQUENCE;

@Entity //database dagi jadval
@Table(name = "City")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "city_id_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "city_id_seq", sequenceName = "city_id_seq", allocationSize = 1)
//    @GenericGenerator(name = "city_id_seq", strategy = SEQUENCE, parameters ={
//            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "city_new_id_seq"),
//            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
//            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//    })
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Village> villages;
}
