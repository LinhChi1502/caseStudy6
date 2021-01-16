package com.case6.quizchallengeweb.controller;

import com.case6.quizchallengeweb.model.question.Category;
import com.case6.quizchallengeweb.model.question.Type;
import com.case6.quizchallengeweb.service.question.category.ICategoryService;
import com.case6.quizchallengeweb.service.question.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/types")
public class TypeController {
    @Autowired
    private ITypeService typeService;


    @GetMapping
    public ResponseEntity<Iterable<Type>> findAllType(){
        return new ResponseEntity<>(typeService.getAll(), HttpStatus.OK);
    }
}
