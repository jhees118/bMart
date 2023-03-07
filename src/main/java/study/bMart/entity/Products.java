package study.bMart.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="products")
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer price;
    private String thumbnail;
    private String title;
    private String content;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")
    private Category category;

    @Builder
    public Products(String title, Integer price, String content , String thumbnail,Category categories){
        this.title = title;
        this.price = price;
        this.content = content;
        this.thumbnail = thumbnail;
        this.category = categories;
    }
}
