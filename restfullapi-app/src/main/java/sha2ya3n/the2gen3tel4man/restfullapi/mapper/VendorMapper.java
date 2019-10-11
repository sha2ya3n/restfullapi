package sha2ya3n.the2gen3tel4man.restfullapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Vendor;
import sha2ya3n.the2gen3tel4man.restfullapi.model.VendorDTO;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    @Mapping(source = "name", target = "name")
    VendorDTO vendorToVendorDTO(Vendor vendor);

    @Mapping(source = "name", target = "name")
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);

}
