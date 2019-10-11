package sha2ya3n.the2gen3tel4man.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}
