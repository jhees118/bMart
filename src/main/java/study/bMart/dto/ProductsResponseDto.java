package study.bMart.dto;
import lombok.Getter;
import study.bMart.entity.Category;
import study.bMart.entity.Products;
import study.bMart.entity.Role;

import java.util.List;


@Getter
public class ProductsResponseDto {

    private Long id;
    private Integer price;
    private String thumbnail;
    private String title;
    private String content;
    private String category;
    public ProductsResponseDto(Products products){
        this.id = products.getId();
        this.price = products.getPrice();
        this.thumbnail = products.getThumbnail();
        this.title = products.getTitle();
        this.content = products.getContent();
        this.category = products.getCategory().getTitle();

    }
}
