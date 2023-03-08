package study.bMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import study.bMart.Response.AccountResponse;
import study.bMart.Response.BasicResponse;
import study.bMart.dto.CategoryDto;
import study.bMart.dto.ProductsRequestDto;
import study.bMart.dto.ProductsResponseDto;
import study.bMart.repository.ProductsRepository;
import study.bMart.service.CategoryService;
import study.bMart.service.ProductsService;


import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductsService productsService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<BasicResponse> getAllProducts(@RequestParam(value = "category",required = false) String category) {
        List<ProductsResponseDto> productsList = productsService.getAllProducts();
        List<ProductsResponseDto> CategoryProductsList = productsService.getCategoryProducts(category);

        BasicResponse basicResponse = new BasicResponse();

        if(StringUtils.isEmpty(category)==false && !CategoryProductsList.isEmpty()){
            basicResponse = BasicResponse.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .message("카테고리별 조회 성공")
                    .result(new ArrayList<>(CategoryProductsList))
                    .count(CategoryProductsList.size())
                    .build();
        }

        else if(StringUtils.isEmpty(category)==false){
            basicResponse = BasicResponse.builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .message("해당 카테고리가 존재하지않습니다.")
                    .result(Collections.emptyList())
                    .count(CategoryProductsList.size())
                    .build();
        }
        else {

            basicResponse = BasicResponse.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .message("전체 상품 조회 성공")
                    .result(new ArrayList<>(productsList))
                    .count(productsList.size())
                    .build();
        }
        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BasicResponse> getProducts(@PathVariable("id") long id) {
        Optional<ProductsResponseDto> productsList = productsService.getProducts(id);

        BasicResponse basicResponse = new BasicResponse();

        if (productsList.isPresent()) {
            basicResponse = BasicResponse.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .message("상품 조회 성공")
                    .result(Arrays.asList(productsList.get()))
                    .count(1).build();

        } else {
            basicResponse = BasicResponse.builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .message("상품을 찾을수 없습니다.")
                    .result(Collections.emptyList())
                    .count(0).build();

        }

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }
    @PostMapping("")
    public ResponseEntity<AccountResponse> productsRegistration(@RequestBody ProductsRequestDto productsRequestDto) {

        AccountResponse accountResponse = new AccountResponse();
        List<CategoryDto.Response> categoryList = categoryService.getAllCategory();

        if(productsRequestDto.getCategory()==null){
            accountResponse = AccountResponse.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .message("카테고리를 입력하지 않았습니다.")
                    .build();
        }
        else if(productsRequestDto.getCategory().getId()!=categoryList.stream().findAny().get().getId()){
            accountResponse = AccountResponse.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .message("올바른 카테고리를 입력해 주세요.")
                    .build();

        }
        else {
            accountResponse = AccountResponse.builder()
                    .code(HttpStatus.CREATED.value())
                    .httpStatus(HttpStatus.CREATED)
                    .message("상품 등록 성공.")
                    .build();
            productsService.productsRegistration(productsRequestDto);
        }
        return new ResponseEntity<>(accountResponse,accountResponse.getHttpStatus());
    }

}