package sha2ya3n.the2gen3tel4man.restfullapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Customer;
import sha2ya3n.the2gen3tel4man.restfullapi.exception.ResourceNotFoundException;
import sha2ya3n.the2gen3tel4man.restfullapi.mapper.CustomerMapper;
import sha2ya3n.the2gen3tel4man.restfullapi.model.CustomerDTO;
import sha2ya3n.the2gen3tel4man.restfullapi.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return customerRepository.findAll().stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.getCustomerDTO(customer);
                    customerDTO.setUrl("/api/v1/customer/" + customer.getId());
                    return customerDTO;
                })
                .collect(Collectors.toList());

    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.getCustomerDTO(customer);
                    customerDTO.setUrl("/api/v1/customer/" + customer.getId());
                    return customerDTO;
                }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return saveAndReturnCustomer(customerMapper.getCustomer(customerDTO));
    }

    private CustomerDTO saveAndReturnCustomer(Customer customer){
        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO returnDto = customerMapper.getCustomerDTO(savedCustomer);

        returnDto.setUrl("/api/v1/customer/" + savedCustomer.getId());

        return returnDto;
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer updateCustomer = customerMapper.getCustomer(customerDTO);
        updateCustomer.setId(id);

        return saveAndReturnCustomer(updateCustomer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if(customerDTO.getFirstname() != null){
                customer.setFirstname(customerDTO.getFirstname());
            }
            if(customerDTO.getLastname() != null){
                customer.setLastname(customerDTO.getLastname());
            }
            return customerMapper.getCustomerDTO(customerRepository.save(customer));
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteCustomer(Long id) {
        for(Customer customer: customerRepository.findAll()){
            if(customer.getId().equals(id)){
                customerRepository.deleteById(id);
            }else{
                throw new ResourceNotFoundException();
            }
        }
    }






    //    @Override
//    public CustomerDTO getCustomerByName(String name) {
//        Customer customer = customerRepository.findByFirstName(name);
//        if(customer != null){
//            CustomerDTO customerDTO = customerMapper.getCustomerDTO(customer);
//            return customerDTO;
//        }
//        return null;
//    }

    //    @Override
//    public CustomerDTO createCustomer(Customer customer) {
//        for(Customer customer1: customerRepository.findAll()){
//            if(!customer.getFirstName().equalsIgnoreCase(customer1.getFirstName())){
//                if(!customer.getLastName().equalsIgnoreCase(customer1.getLastName())){
//                    if(!customer.getId().equals(customer1.getId())){
//                        customerRepository.save(customer);
//                        return customerMapper.getCustomerDTO(customer);
//                    }
//                }
//            }
//        }
//        return null;
//    }
}
