package edu.depaul.cdm.se452.concept.database.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reviews")
public class Review {
    @Id
    private String id;
    private String instructorID;
    private String instructorName;
    private String courseName;
    private Double rating;
}


