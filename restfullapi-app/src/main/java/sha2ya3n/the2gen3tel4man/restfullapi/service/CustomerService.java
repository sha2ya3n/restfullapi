package sha2ya3n.the2gen3tel4man.restfullapi.service;

import sha2ya3n.the2gen3tel4man.restfullapi.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO getCustomerById(Long id);

    List<CustomerDTO> getAllCustomer();

//    CustomerDTO getCustomerByName(String name);

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomer(Long id);
}
