package study.bMart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.bMart.dto.CategoryDto;
import study.bMart.dto.ProductsResponseDto;
import study.bMart.entity.Category;
import study.bMart.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;




    public void categoryDelete(Long id){


        categoryRepository.deleteById(id);
    }


    public List<CategoryDto.Response> getAllCategory(){
        return  categoryRepository.findAll().stream()
                .map(CategoryDto.Response::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Category categoryRegistration(CategoryDto.Request request){
        return categoryRepository.save(request.toEntity());
    }

    public Optional<CategoryDto.Response> getCategory(Long id){

        return categoryRepository.findById(id).map(CategoryDto.Response::new);
    }

}
