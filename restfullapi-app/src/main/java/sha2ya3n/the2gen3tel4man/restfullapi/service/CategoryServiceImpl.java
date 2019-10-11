package sha2ya3n.the2gen3tel4man.restfullapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sha2ya3n.the2gen3tel4man.restfullapi.domain.Category;
import sha2ya3n.the2gen3tel4man.restfullapi.mapper.CategoryMapper;
import sha2ya3n.the2gen3tel4man.restfullapi.model.CategoryDTO;
import sha2ya3n.the2gen3tel4man.restfullapi.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {

        return categoryRepository.findAll().stream()
                .map(category -> categoryMapper.categoryToCategoryDTO(category))
                .collect(Collectors.toList());

        // the second way of implementation
//        List<Category> categories = categoryRepository.findAll();
//
//        List<CategoryDTO> dtoList = new LinkedList<>();
//        for (Category category : categories) {
//            CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
//            dtoList.add(categoryDTO);
//            if(dtoList != null){
//                return dtoList;
//            }
//
//        }
//        return null;

    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name);
        return categoryMapper.categoryToCategoryDTO(category);

        // second way of implementation
//        for(Category category: categoryRepository.findAll()){
//            if(category.getName().equalsIgnoreCase(name)){
//                CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
//                return categoryDTO;
//            }
//        }
//        return null;
    }
}
