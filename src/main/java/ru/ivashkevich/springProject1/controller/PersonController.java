package ru.ivashkevich.springProject1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ivashkevich.springProject1.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PersonController {
    private final PersonDAO personDAO;

    @Autowired
    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String showAllPeople(Model model){
        model.addAttribute("people", personDAO.getAllPeople());

        return "people/all-people";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable int id, Model model){
        model.addAttribute("person", personDAO.getPersonById(id));

        return "people/person";
    }
}
