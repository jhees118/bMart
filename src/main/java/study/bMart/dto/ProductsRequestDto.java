package study.bMart.dto;

import lombok.*;
import study.bMart.entity.Category;
import study.bMart.entity.Products;
import study.bMart.entity.Role;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class ProductsRequestDto {


    private Integer price;
    private String thumbnail;

    private String title;
    private String content;

    private Category categories;


    @Builder
    public ProductsRequestDto(String title, Integer price,  String content , String thumbnail,Category category){
        this.title = title;
        this.price = price;
        this.content = content;
        this.thumbnail = thumbnail;
        this.categories = category;

    }

    public Products toEntity(){

        return  Products.builder().content(content).price(price).title(title).thumbnail(thumbnail).categories(categories).build();
    }

}