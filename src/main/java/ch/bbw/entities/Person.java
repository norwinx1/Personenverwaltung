package ch.bbw.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(min = 2, max = 30, message
            = "Firstname must be between 2 and 30 characters")
    private String firstname;

    @Size(min = 2, max = 30, message
            = "Lastname must be between 2 and 30 characters")
    private String lastname;

    @Email(message = "Email should be valid")
    private String email;

    @Temporal(TemporalType.DATE)
    @Past(message = "Birthdate should be in the past")
    @NotNull(message = "Birthdate should not be null")
    private Date birthdate;

    @NotNull(message = "Gender should not be null")
    private char gender;
}
