package study.bMart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.bMart.dto.CategoryRequestDto;
import study.bMart.entity.Category;
import study.bMart.repository.CategoryRepository;

import javax.transaction.Transactional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    //카테고리 등록
    @Transactional
    public Category categoryRegistration(CategoryRequestDto categoryRequestDto){

        return categoryRepository.save(categoryRequestDto.toEntity());
    }
}
