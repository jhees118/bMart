package study.bMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.bMart.entity.Category;


public interface CategoryRepository extends JpaRepository<Category,Long> {
}
