package sha2ya3n.the2gen3tel4man.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    Customer findByFirstName(String firstname);
}
