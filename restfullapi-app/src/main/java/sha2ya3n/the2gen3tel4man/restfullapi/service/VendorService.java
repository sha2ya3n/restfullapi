package sha2ya3n.the2gen3tel4man.restfullapi.service;

import sha2ya3n.the2gen3tel4man.restfullapi.model.VendorDTO;

import java.util.List;

public interface VendorService {

    VendorDTO getVendorDTOById(Long id);

    List<VendorDTO> getAllVendor();

    VendorDTO creatVendor(VendorDTO vendorDTO);

    VendorDTO updateVendor(Long id, VendorDTO vendorDTO);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendor(Long id);
}
