package study.bMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.bMart.Response.AccountResponse;
import study.bMart.Response.BasicResponse;
import study.bMart.dto.CategoryRequestDto;
import study.bMart.dto.CategoryResponseDto;
import study.bMart.dto.ProductsResponseDto;
import study.bMart.service.CategoryService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<BasicResponse> getAllCategory(@RequestParam(value = "category",required = false) String category) {
        List<CategoryResponseDto> categoryList = categoryService.getAllCategory();

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
    public ResponseEntity<AccountResponse> categoryRegistration(@RequestBody CategoryRequestDto categoryRequestDto) {

        AccountResponse accountResponse = new AccountResponse();

        accountResponse = AccountResponse.builder()
                .code(HttpStatus.CREATED.value())
                .httpStatus(HttpStatus.CREATED)
                .message("카테고리 등록 완료.")
                .build();
        categoryService.categoryRegistration(categoryRequestDto);

        return new ResponseEntity<>(accountResponse,accountResponse.getHttpStatus());
    }

}
