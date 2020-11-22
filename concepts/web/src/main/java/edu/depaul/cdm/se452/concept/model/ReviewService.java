package edu.depaul.cdm.se452.concept.model;
import edu.depaul.cdm.se452.concept.database.mongo.domain.RecordNotFoundException;
import edu.depaul.cdm.se452.concept.database.mongo.domain.Review;
import edu.depaul.cdm.se452.concept.database.mongo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    public List<Review> getAllReviews()
    {
        List<Review> result = (List<Review>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Review>();
        }
    }

    public Review getReviewById(String id) throws RecordNotFoundException
    {
        Optional<Review> review = repository.findById(id);

        if(review.isPresent()) {
            return review.get();
        } else {
            throw new RecordNotFoundException("No review found for this ID");
        }
    }

    public Review createOrUpdateReview(Review entity)
    {
        System.out.println("createOrUpdateReview");
        // Create new entry
        if(entity.getId()  == null)
        {
            entity = repository.save(entity);

            return entity;
        }
        else
        {
            // update existing entry
            Optional<Review> review = repository.findById(entity.getId());

            if(review.isPresent())
            {
                Review newEntity = review.get();
                newEntity.setInstructorName(entity.getInstructorName());
                newEntity.setCourseName(entity.getCourseName());
                newEntity.setRating(entity.getRating());
                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }
    }

    public void deleteReviewById(String id) throws RecordNotFoundException
    {
        System.out.println("deleteReviewById");

        Optional<Review> review = repository.findById(id);

        if(review.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No review found for this ID");
        }
    }
}