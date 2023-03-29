package study.bMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.bMart.entity.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User  findByUsername(String username);
    boolean existsByUsername(String username);
}
