package study.bMart.dto;

import lombok.Getter;
import study.bMart.entity.Category;



@Getter
public class CategoryResponseDto {

    private Long id;
    private String title;

    public CategoryResponseDto(Category category){
        this.id = category.getId();
        this.title = category.getTitle();
    }
}