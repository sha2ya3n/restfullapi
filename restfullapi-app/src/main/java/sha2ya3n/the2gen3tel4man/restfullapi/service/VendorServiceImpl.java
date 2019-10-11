package sha2ya3n.the2gen3tel4man.restfullapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Vendor;
import sha2ya3n.the2gen3tel4man.restfullapi.exception.ResourceNotFoundException;
import sha2ya3n.the2gen3tel4man.restfullapi.mapper.VendorMapper;
import sha2ya3n.the2gen3tel4man.restfullapi.model.VendorDTO;
import sha2ya3n.the2gen3tel4man.restfullapi.repository.VendorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public VendorDTO getVendorDTOById(Long id) {
        return vendorRepository.findById(id).map(vendor -> {
            VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
            vendorDTO.setVendorUrl("/api/v1/vendor/" + vendor.getId());
            return vendorDTO;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<VendorDTO> getAllVendor() {
        return vendorRepository.findAll().stream().map(vendor -> {
            VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
            vendorDTO.setVendorUrl("/api/v1/vendor/" + vendor.getId());
            return vendorDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public VendorDTO creatVendor(VendorDTO vendorDTO) {
        return saveAndReturn(vendorMapper.vendorDTOToVendor(vendorDTO));
    }

    private VendorDTO saveAndReturn(Vendor vendor){
        Vendor savedVendor = vendorRepository.save(vendor);

        VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(savedVendor);

        vendorDTO.setVendorUrl("/api/v1/vendor/" + savedVendor.getId());
        return vendorDTO;
    }

    @Override
    public VendorDTO updateVendor(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        vendor.setId(id);
        return saveAndReturn(vendor);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return vendorRepository.findById(id).map(vendor -> {
            if(vendorDTO.getName() != null){
                vendor.setName(vendorDTO.getName());
            }
            return saveAndReturn(vendor);

        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteVendor(Long id) {
        for(Vendor vendor: vendorRepository.findAll()){
            if(vendor.getId().equals(id)){
                vendorRepository.deleteById(id);
            }else{
                throw new ResourceNotFoundException("Resource not found Exception");
            }
        }

//        vendorRepository.deleteById(id);
    }
}
