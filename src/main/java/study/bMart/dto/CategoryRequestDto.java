package study.bMart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.bMart.entity.Category;


@NoArgsConstructor
@Getter
public class CategoryRequestDto {



    private String title;



    @Builder
    public CategoryRequestDto(String title){
        this.title = title;




    }

    public Category toEntity(){

        return  Category.builder().title(title).build();
    }
}
