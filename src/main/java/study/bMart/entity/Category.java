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
    private String title;

    private String content;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Products> products = new ArrayList<>();


    @Builder
    public Category(String title){
        this.title = title;

    }
}