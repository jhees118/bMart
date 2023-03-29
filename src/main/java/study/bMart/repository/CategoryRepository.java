package study.bMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import study.bMart.entity.Category;


public interface CategoryRepository extends JpaRepository<Category,Long> {
//    @Query("update Category as c set title = :title where id = :id")
//    int updateT(Long id,String title);
}
