package com.example.homework19.Service;

import com.example.homework19.ApiException.ApiException;
import com.example.homework19.Model.Blog;
import com.example.homework19.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    public List<Blog> getAllBlog(){
        return blogRepository.findAll();
    }

    public void addBlog(Blog blog){
        blogRepository.save(blog);
    }

    public void updateBlog(Integer id, Blog blog){
        Blog old= blogRepository.findBlogById(id);
        if (old==null) {
            throw new ApiException("Wrong Updated");
        }
       old.setId(blog.getId());
        old.setTitle(blog.getTitle());
        old.setCategory(blog.getCategory());
        old.setBody(blog.getBody());
        old.setPublished(blog.isPublished());
        blogRepository.save(old);
        }

    public void deleteBlog(Integer id) {
        Blog old = blogRepository.findBlogById(id);
        if (old==null){
            throw new ApiException("not deleted");
        }
        blogRepository.delete(old);
    }

    public Blog findBlogById(Integer id){
        Blog blog=blogRepository.findBlogById(id);
        if (blog==null) {
            throw new ApiException("Not Found");
        }
        return blog;
    }

    public List<Blog> findBlogByTitle(String title){
        List<Blog>blogs=blogRepository.findBlogByTitle(title);
        if (blogs==null){
            throw new ApiException("Not found");
        }
        return blogs;
    }

    public List<Blog>findBlogByCategory(String category){
        List<Blog>blogs=blogRepository.findBlogByCategory(category);
        if (blogs==null){
            throw new ApiException("Not found");
        }
        return blogs;
    }
    public Blog findBlogByBody(String body){
        Blog blog=blogRepository.findBlogByBody(body);
        if (blog==null) {
            throw new ApiException("Not Found");
        }
        return blog;
    }


    public void ChangeIsPublished(Integer id){
        Blog blog = blogRepository.getBlogById(id);
        blog.setPublished(true);
        blogRepository.save(blog);
    }

}



