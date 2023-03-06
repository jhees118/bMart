package study.bMart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="category")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "categoryId",cascade = CascadeType.REMOVE)
    private List<Products> productsList = new ArrayList<>();


    @Builder
    public Category(String title,  String image){
        this.title = title;
        this.image = image;
    }
}