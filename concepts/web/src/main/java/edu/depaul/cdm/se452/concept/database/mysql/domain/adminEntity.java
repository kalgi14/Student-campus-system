package edu.depaul.cdm.se452.concept.database.mysql.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "admins")
@Data
public class adminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ADMIN_ID")
    int ADMIN_ID;
    @Column (name = "FIRST_NAME")
    String FIRST_NAME;
    @Column (name = "LAST_NAME")
    String LAST_NAME;
}
