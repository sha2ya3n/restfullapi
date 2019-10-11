package sha2ya3n.the2gen3tel4man.restfullapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerListDTO {

    private List<CustomerDTO> getCustomers;
}
