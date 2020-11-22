package edu.depaul.cdm.se452.concept.controller;

import edu.depaul.cdm.se452.concept.database.mongo.domain.RecordNotFoundException;
import edu.depaul.cdm.se452.concept.database.mongo.domain.Review;
import edu.depaul.cdm.se452.concept.model.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("review")
public class ReviewController {
    @Autowired
    ReviewService service;

    @RequestMapping
    public String getAllReviews(Model model) {

        List<Review> list = service.getAllReviews();

        model.addAttribute("reviews", list);

        return "list-reviews";
    }


    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editReviewById(Model model, @PathVariable("id") Optional<String> id)
            throws RecordNotFoundException {

        if (id.isPresent()) {
            Review entity = service.getReviewById(id.get());
            model.addAttribute("review", entity);
        } else {
            model.addAttribute("review", new Review());
        }


        return "add-edit-review";
    }

    @RequestMapping(path = "/createReview", method = RequestMethod.POST)
    public String createOrUpdateReview(Review review) {

        service.createOrUpdateReview(review);

        return "redirect:/review";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") String id)
            throws RecordNotFoundException {

        System.out.println("deleteEmployeeById" + id);

        service.deleteReviewById(id);
        return "redirect:/review";
    }
}