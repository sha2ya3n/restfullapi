package sha2ya3n.the2gen3tel4man.restfullapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Category;
import sha2ya3n.the2gen3tel4man.restfullapi.model.CategoryDTO;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "id" , target = "id")
    CategoryDTO categoryToCategoryDTO(Category category);
}
