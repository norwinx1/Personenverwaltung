package ch.bbw.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstname;

    private String lastname;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthdate;

    private char gender;
}
