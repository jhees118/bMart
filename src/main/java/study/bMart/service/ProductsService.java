package study.bMart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.bMart.dto.ProductsRequestDto;
import study.bMart.dto.ProductsResponseDto;
import study.bMart.entity.Products;
import study.bMart.repository.ProductsRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    //상품 전체 조회
    public List<ProductsResponseDto> getAllProducts(){
        return productsRepository.findAll().stream()
                .map(ProductsResponseDto::new)
                .collect(Collectors.toList());
    }
    //카테고리별 상품 조회
    /*
    public List<ProductsResponseDto> getCategoryProducts(String Category){
        return productsRepository.findByCategory(Category).stream()
                .map(ProductsResponseDto::new)
                .collect(Collectors.toList());
    }
    */

    public Optional<ProductsResponseDto> getProducts(Long id){

        return productsRepository.findById(id).map(ProductsResponseDto::new);
    }

    @Transactional
    public Products productsRegistration(ProductsRequestDto productsRequestDto){

        return productsRepository.save(productsRequestDto.toEntity());
    }

}
