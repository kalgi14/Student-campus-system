package edu.depaul.cdm.se452.concept.database.mongo.repository;

import edu.depaul.cdm.se452.concept.database.mongo.domain.Review;
import edu.depaul.cdm.se452.concept.database.mysql.domain.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {


}
