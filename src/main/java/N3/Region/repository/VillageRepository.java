package N3.Region.repository;

import N3.Region.entity.City;
import N3.Region.entity.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillageRepository extends JpaRepository<Village, Integer> {
    List<Village> findAllByIdAndName(Integer id, String name);
}
