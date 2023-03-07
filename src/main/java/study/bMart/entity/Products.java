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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name ="products_category",
            joinColumns = @JoinColumn(name ="products_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    @Builder
    public Products(String title, Integer price, String content , String thumbnail,List<Category> categories){
        this.title = title;
        this.price = price;
        this.content = content;
        this.thumbnail = thumbnail;
        this.categories = categories;
    }
}
