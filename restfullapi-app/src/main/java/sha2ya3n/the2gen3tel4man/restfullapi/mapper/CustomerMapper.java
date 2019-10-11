package sha2ya3n.the2gen3tel4man.restfullapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Customer;
import sha2ya3n.the2gen3tel4man.restfullapi.model.CustomerDTO;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    CustomerDTO getCustomerDTO(Customer customer);

    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    Customer getCustomer(CustomerDTO customerDTO);
}
