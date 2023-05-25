package com.example.homework19.Controller;

import com.example.homework19.ApiResponse.ApiResponse;
import com.example.homework19.Model.Blog;
import com.example.homework19.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(blogService.getAllBlog());
    }

    @PostMapping("add")
    public ResponseEntity addAllBlog(@Valid @RequestBody Blog blog){
       blogService.addBlog(blog);
        return ResponseEntity.status(200).body("Successful Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Blog blog,@PathVariable Integer id ){
      blogService.updateBlog(id,blog);
        return ResponseEntity.status(200).body(new ApiResponse("Successful Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){
      blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("Successful deleted");
    }
@GetMapping("/get-id")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        Blog blogs=blogService.findBlogById(id);
        return ResponseEntity.status(200).body(blogs);
}

@GetMapping("/get-title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
        List<Blog>blogs=blogService.findBlogByTitle(title);
        return ResponseEntity.status(200).body(blogs);
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getBlogByCategory(@PathVariable String category){
        List<Blog>blogs=blogService.findBlogByCategory(category);
        return ResponseEntity.status(200).body(blogs);
    }
 @GetMapping("/get-body/{body}")
    public ResponseEntity getBlogByBody(@PathVariable String body){
        Blog blog=blogService.findBlogByBody(body);
        return ResponseEntity.status(200).body(blog);
 }
    @PutMapping("/change-published/{id}")
    public ResponseEntity ChangeIsPublished(@PathVariable Integer id){
        blogService.ChangeIsPublished(id);
        return ResponseEntity.status(200).body("Changed to true");
    }
//@PutMapping("/chang-published/{id}")
//    public ResponseEntity getChangeIsPublished(@PathVariable Integer id){
//       Blog blog= blogService.ChangeIsPublished(id);
//        return ResponseEntity.status(200).body(blog);
//}
}
