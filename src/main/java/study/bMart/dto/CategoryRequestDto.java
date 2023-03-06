package study.bMart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.bMart.entity.Category;


@NoArgsConstructor
@Getter
public class CategoryRequestDto {

    private String image;

    private String title;



    @Builder
    public CategoryRequestDto(String title, String image){
        this.title = title;

        this.image = image;


    }

    public Category toEntity(){

        return  Category.builder().image(image).title(title).build();
    }
}
