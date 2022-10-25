package N3.Region.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

import static org.hibernate.id.SequenceGenerator.SEQUENCE;

@Entity
@Table(name = "village")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Village {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "village_id_seq" , strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "village_id_seq",sequenceName = "village_id_seq", allocationSize = 1)
//    @GenericGenerator(name = "village_id_seq", strategy = SEQUENCE, parameters ={
//
//            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "village_id_new_seq"),
//            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
//            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//
//    })
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "village")
    private List<Person> personList;

    @ManyToOne
    private City city;
}
