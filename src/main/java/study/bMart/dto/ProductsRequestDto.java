package study.bMart.dto;

import lombok.*;
import study.bMart.entity.Products;


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



    @Builder
    public ProductsRequestDto(String title, Integer price,  String content , String thumbnail){
        this.title = title;
        this.price = price;
        this.content = content;
        this.thumbnail = thumbnail;


    }

    public Products toEntity(){

        return  Products.builder().content(content).price(price).title(title).thumbnail(thumbnail).build();
    }

}