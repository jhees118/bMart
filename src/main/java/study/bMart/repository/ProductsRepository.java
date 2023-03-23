package study.bMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.bMart.entity.Products;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products,Long> {
    List<Products> findByCategory_Title(String category);
    Optional<Products> findByCategory_Id(Long id);
}
