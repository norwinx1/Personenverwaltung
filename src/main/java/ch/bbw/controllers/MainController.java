package ch.bbw.controllers;

import ch.bbw.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class MainController {
    private PersonService personService;

    @GetMapping("/persons")
    public String persons(Model model) {
        model.addAttribute("persons", personService.getPersons());
        return "persons";
    }

    @GetMapping("/persons/{id}")
    public String person(Model model, @PathVariable int id) {
        model.addAttribute("person", personService.getPerson(id));
        return "person";
    }
}
