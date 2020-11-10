package edu.depaul.cdm.se452.concept.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

import edu.depaul.cdm.se452.concept.model.ICategoryService;
import edu.depaul.cdm.se452.concept.database.mysql.repository.CategoryRepository;
import edu.depaul.cdm.se452.concept.database.mysql.domain.CategoryEntity;

@RequestMapping("CategoryEntity")
@Slf4j
@Controller
public class TestController {

    private CategoryRepository categoryRepository;
    private ICategoryService categoryRepository2;

    @Autowired
    TestController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("list-students");
        mv.addObject("students", categoryRepository.findAll());
        return mv;
    }

//    @RequestMapping(value = "category", method = RequestMethod.POST)
//    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity domain) {
//
//        categoryRepository.save(domain);
//        return ResponseEntity.ok(domain);
//    }
//
//    @RequestMapping(value = "all", method = RequestMethod.GET)
//    public Map<String, Object> getAll() {
//        final Map<String, Object> result = new HashMap<>();
//        result.put("category", categoryRepository.findAll());
//
//        return result;
//    }
}
