package ch.bbw.entities;

import ch.bbw.validation.BirthdateConstraint;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Email should not be blank")
    @Email(message = "Email should be valid")
    private String email;

    @Temporal(TemporalType.DATE)
    @BirthdateConstraint(message = "Birthdate should be before 2005")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    @NotNull(message = "Gender should not be null")
    private char gender;
}
