package com.example.homework19.Repository;

import com.example.homework19.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {


    Blog findBlogById(Integer id);

    List<Blog> findBlogByTitle(String title);

    List<Blog> findBlogByCategory(String category);
    Blog findBlogByBody(String body);


    Blog getBlogById(Integer id);
}
