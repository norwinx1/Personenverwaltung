package ch.bbw.controllers;

import ch.bbw.entities.Person;
import ch.bbw.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@Slf4j
public class MainController implements WebMvcConfigurer {
    private PersonService personService;

    @GetMapping("/persons")
    public String getPersons(Model model) {
        model.addAttribute("persons", personService.getPersons());
        return "persons";
    }

    @GetMapping("/person")
    public String newPersonView(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }

    @PostMapping("/person")
    public String changeOrAddPerson(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "person";
        }
        personService.addPerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/persons/{id}")
    public String getPerson(Model model, @PathVariable int id) {
        model.addAttribute("person", personService.getPerson(id));
        return "person";
    }

    @PostMapping("/person/{id}/delete")
    public String deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }
}
