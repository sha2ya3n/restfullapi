package sha2ya3n.the2gen3tel4man.restfullapi.service;

import sha2ya3n.the2gen3tel4man.restfullapi.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
