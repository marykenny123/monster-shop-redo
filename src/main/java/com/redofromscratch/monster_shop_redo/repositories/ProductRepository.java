package com.redofromscratch.monster_shop_redo.repositories;

import com.redofromscratch.monster_shop_redo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
