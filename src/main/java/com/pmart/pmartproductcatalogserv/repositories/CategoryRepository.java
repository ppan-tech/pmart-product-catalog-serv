package com.pmart.pmartproductcatalogserv.repositories;


import com.pmart.pmartproductcatalogserv.models.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    Optional<Category> findByName(String category);

    Category save(Category category);

    @EntityGraph(attributePaths = {"products"})  //makes a separate query to fetch products for all categories eagerly, avoid N+1 problem.
    List<Category> findAll();

    @Query("select c from Category c join fetch c.products")
    List<Category> getCategoriesUsingJoinFetch();
}