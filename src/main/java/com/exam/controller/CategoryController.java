package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.service.definition.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    //Add Category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category1= this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }


    //Get Category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return this.categoryService.getCategory(categoryId);
    }

    //Get Category List
    @GetMapping("/")
    public Set<Category> getCategories(){
        return new HashSet<>(this.categoryService.getCategories());
    }

    //Update Category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category){
       return this.categoryService.updateCategory(category);
    }

    //Delete Category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){

        this.categoryService.deleteCategory(categoryId);
    }

}
