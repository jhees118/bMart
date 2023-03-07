package study.bMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.bMart.entity.Products;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products,Long> {
    List<Products> findByCategory_Title(String category);
}
