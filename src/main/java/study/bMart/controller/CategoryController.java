package study.bMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.bMart.Response.AccountResponse;
import study.bMart.Response.BasicResponse;
import study.bMart.dto.CategoryDto;
import study.bMart.dto.ProductsResponseDto;
import study.bMart.entity.Category;
import study.bMart.repository.ProductsRepository;
import study.bMart.service.CategoryService;
import study.bMart.service.ProductsService;

import java.util.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("")
    public ResponseEntity<BasicResponse> getAllCategory(@RequestParam(value = "category",required = false) String category) {
        List<CategoryDto.Response> categoryList = categoryService.getAllCategory();


        BasicResponse basicResponse = new BasicResponse();

            basicResponse = BasicResponse.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .message("카테고리 조회 성공")
                    .result(new ArrayList<>(categoryList))
                    .count(categoryList.size())
                    .build();

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }
    @PostMapping("")
    public ResponseEntity<AccountResponse> categoryRegistration(@RequestBody CategoryDto.Request request) {

        AccountResponse accountResponse = new AccountResponse();
        accountResponse = AccountResponse.builder()
                .code(HttpStatus.CREATED.value())
                .httpStatus(HttpStatus.CREATED)
                .message("카테고리 등록 완료.")
                .build();
        categoryService.categoryRegistration(request);

        return new ResponseEntity<>(accountResponse,accountResponse.getHttpStatus());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<BasicResponse> categoryDelete(@PathVariable(value = "id") Long id) {

        BasicResponse basicResponse = new BasicResponse();

        Optional<ProductsResponseDto> cate = productsService.getCategoryIdProducts(id);
    if() {
        basicResponse = BasicResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("카테고리 삭제 완료")
                .result(Collections.emptyList())
                .count(1).build();
        categoryService.categoryDelete(id);

    }
    else if(cate.isPresent()){
        basicResponse = BasicResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .httpStatus(HttpStatus.NOT_FOUND)
                .message("해당 카테고리를 찾을수없습니다.")
                .result(Collections.emptyList())
                .count(0).build();
        }
    else{
        basicResponse = BasicResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("상품 카테고리 id를 변경해야합니다")
                .result(Collections.emptyList())
                .count(0).build();

    }



        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());

    }


}
