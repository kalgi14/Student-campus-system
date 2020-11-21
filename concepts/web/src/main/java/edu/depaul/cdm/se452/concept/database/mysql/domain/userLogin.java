package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class userLogin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = true)
    private Integer user_id;

    @Column(name = "admin_id", nullable = true)
    private Integer admin_id;

    @Column(name = "professor_id", nullable = true)
    private Integer professor_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private Integer enabled;
}
