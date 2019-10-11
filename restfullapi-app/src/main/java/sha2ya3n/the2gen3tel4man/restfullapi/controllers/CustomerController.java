package sha2ya3n.the2gen3tel4man.restfullapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sha2ya3n.the2gen3tel4man.restfullapi.model.CustomerDTO;
import sha2ya3n.the2gen3tel4man.restfullapi.model.CustomerListDTO;
import sha2ya3n.the2gen3tel4man.restfullapi.repository.CustomerRepository;
import sha2ya3n.the2gen3tel4man.restfullapi.service.CustomerService;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomer(){
        return new ResponseEntity<CustomerListDTO>(
                new CustomerListDTO(customerService.getAllCustomer()), HttpStatus.OK
        );
    }

    // Should only use one of these if use name cant use id both together and vice versa
//    @GetMapping("{name}")
//    public ResponseEntity<CustomerDTO> getCustomerByName(@PathVariable String name){
//
//        return new ResponseEntity<CustomerDTO>(
//                customerService.getCustomerByName(name), HttpStatus.OK);
//    }

    @GetMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<CustomerDTO>(
                customerService.createCustomer(customerDTO), HttpStatus.CREATED
        );
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<CustomerDTO>(
                customerService.updateCustomer(id, customerDTO), HttpStatus.OK
        );
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<CustomerDTO> patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<CustomerDTO>(
                customerService.patchCustomer(id, customerDTO), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
