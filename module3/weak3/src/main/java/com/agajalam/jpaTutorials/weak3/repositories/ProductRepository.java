package com.agajalam.jpaTutorials.weak3.repositories;

import com.agajalam.jpaTutorials.weak3.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

//   List<ProductEntity> findByOrderByPrice();
   List<ProductEntity> findBy(Sort sort);





    //custom
//    ProductEntity findByTitle(String title);
//
//    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);
//
//    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal price);
//
//    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int quantity, BigDecimal price);
//
//    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price);
//
    List<ProductEntity>findByTitleContainingIgnoreCase(String title, Pageable pageable);


//   Optional< ProductEntity> findByTitleAndPrice(String title, BigDecimal price);



    //custom query
//   @Query("select e.title from ProductEntity e where e.title=:title and e.price=:price")
//   @Query("select e from ProductEntity e where e.title=:title and e.price=:price")
//   Optional< ProductEntity> findByTitleAndPrice(String title, BigDecimal price);




}
