package sha2ya3n.the2gen3tel4man.restfullapi.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Category;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Customer;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Vendor;
import sha2ya3n.the2gen3tel4man.restfullapi.repository.CategoryRepository;
import sha2ya3n.the2gen3tel4man.restfullapi.repository.CustomerRepository;
import sha2ya3n.the2gen3tel4man.restfullapi.repository.VendorRepository;

@Component
public class bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategory();
        loadCustomer();
        loadVendors();

    }

    private void loadVendors(){
        Vendor vendor1 = new Vendor();
        vendor1.setName("Shayan");
        vendor1.setId(1L);
        vendorRepository.save(vendor1);

        Vendor vendor2 = new Vendor();
        vendor2.setId(2L);
        vendor2.setName("Shina");
        vendorRepository.save(vendor2);

        Vendor vendor3 = new Vendor();
        vendor3.setName("Ali");
        vendor3.setId(3L);
        vendorRepository.save(vendor3);

        Vendor vendor4 = new Vendor();
        vendor4.setId(4L);
        vendor4.setName("Vendor number four");
        vendorRepository.save(vendor4);

        System.out.println("Venders data are loaded from bootstrap");
    }

    private void loadCustomer() {
        Customer shayan = new Customer();
        shayan.setFirstname("Shayan");
        shayan.setLastname("Khademian");
        shayan.setId(1L);

        Customer shina = new Customer();
        shina.setFirstname("Shina");
        shina.setLastname("Khademian");
        shina.setId(2L);

        Customer ali = new Customer();
        ali.setFirstname("Ali");
        ali.setLastname("Amiri");
        ali.setId(3L);

        Customer asqar = new Customer();
        asqar.setFirstname("Asqar");
        asqar.setLastname("Asqari");
        asqar.setId(4L);

        customerRepository.save(shayan);
        customerRepository.save(shina);
        customerRepository.save(ali);
        customerRepository.save(asqar);

        System.out.println("Customers loaded from bootstrap class " + customerRepository.count());
    }

    private void loadCategory() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(exotic);
        categoryRepository.save(fresh);
        categoryRepository.save(nuts);

        System.out.println("Data loaded form bootstrap is about: " +categoryRepository.count());

    }
}
