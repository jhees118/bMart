package study.bMart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.bMart.Response.AccountResponse;
import study.bMart.dto.CategoryRequestDto;
import study.bMart.service.CategoryService;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

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
