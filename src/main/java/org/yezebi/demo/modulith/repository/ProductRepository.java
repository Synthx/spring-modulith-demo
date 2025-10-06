package org.yezebi.demo.modulith.repository;

import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yezebi.demo.modulith.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
  @Query("select p from Product p join fetch p.user")
  Page<Product> findAllBy(final Pageable pageable);
}
