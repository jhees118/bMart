package study.bMart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.bMart.dto.CategoryRequestDto;
import study.bMart.dto.CategoryResponseDto;
import study.bMart.dto.ProductsResponseDto;
import study.bMart.entity.Category;
import study.bMart.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryResponseDto> getAllCategory(){
        return categoryRepository.findAll().stream()
                .map(CategoryResponseDto::new)
                .collect(Collectors.toList());
    }

    //카테고리 등록
    @Transactional
    public Category categoryRegistration(CategoryRequestDto categoryRequestDto){

        return categoryRepository.save(categoryRequestDto.toEntity());
    }
}
