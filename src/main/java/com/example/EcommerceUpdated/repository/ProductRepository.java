package com.example.EcommerceUpdated.repository;

import com.example.EcommerceUpdated.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("Select p From Product p Where p.price > :minPrice")
    public List<Product> findExpensiveProducts(@Param("minPrice") int minPrice);

    @Query(value = "Select * from Product WHERE MATCH(title,description) Against (:keyword)",nativeQuery = true)
    public List<Product> findTextSearch(@Param("keyword") String keyword);
}
