package sha2ya3n.the2gen3tel4man.restfullapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sha2ya3n.the2gen3tel4man.restfullapi.model.CategoryDTO;
import sha2ya3n.the2gen3tel4man.restfullapi.model.CategoryListDTO;
import sha2ya3n.the2gen3tel4man.restfullapi.service.CategoryService;

@Controller
@RequestMapping("/api/v1/categories/")
public class CategoryControllers {

    private final CategoryService categoryService;

    public CategoryControllers(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CategoryListDTO> listOfCategoryDTO(){
        return new  ResponseEntity<CategoryListDTO>(
                new CategoryListDTO(categoryService.getAllCategories()), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name){
        return new ResponseEntity<CategoryDTO>(
                categoryService.getCategoryByName(name), HttpStatus.OK
        );
    }
}
