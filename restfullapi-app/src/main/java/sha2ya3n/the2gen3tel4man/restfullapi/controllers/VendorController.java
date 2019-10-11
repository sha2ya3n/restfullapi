package sha2ya3n.the2gen3tel4man.restfullapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sha2ya3n.the2gen3tel4man.restfullapi.model.VendorDTO;
import sha2ya3n.the2gen3tel4man.restfullapi.model.VendorListDTO;
import sha2ya3n.the2gen3tel4man.restfullapi.repository.VendorRepository;
import sha2ya3n.the2gen3tel4man.restfullapi.service.VendorService;

@Controller
@RequestMapping("/api/v1/vendors/")
public class VendorController {

    private final VendorRepository vendorRepository;
    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorRepository vendorRepository, VendorService vendorService) {
        this.vendorRepository = vendorRepository;
        this.vendorService = vendorService;
    }

    @GetMapping
    public ResponseEntity<VendorListDTO> getAllVendor(){
        return new ResponseEntity<VendorListDTO>(
                new VendorListDTO(vendorService.getAllVendor()), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<VendorDTO> getVendorById(@PathVariable Long id){
        return new ResponseEntity<VendorDTO>(
                vendorService.getVendorDTOById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VendorDTO> createVendor(@RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(
                vendorService.creatVendor(vendorDTO), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<VendorDTO> updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(
                vendorService.updateVendor(id, vendorDTO), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<VendorDTO> patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(
                vendorService.patchVendor(id, vendorDTO), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id){
        vendorService.deleteVendor(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
