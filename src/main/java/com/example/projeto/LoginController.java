package com.example.projeto;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes({"username","TasksLists"})
public class LoginController {

    private AuthenticationService authenticationService = new AuthenticationService();
    private com.example.projeto.TasksListService tasksListService = new com.example.projeto.TasksListService();

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String showWelcomePage(@RequestParam String username, @RequestParam String password, ModelMap model) {

        List<TasksList> TasksLists = tasksListService.findByUsername("Admin");

        if (authenticationService.Autheticate(username, password)) {
            model.addAttribute("username", username);
            model.addAttribute("TasksLists", TasksLists);
            return "welcome";
        }
        model.addAttribute("errorMessage", "Invalid Credentials! Please try again.");
        return "login";
    }

    @GetMapping("register")
    public String showRegisterForm() {
        return "register";
    }

    @RequestMapping(value="newtasks", method = RequestMethod.GET)
    public String showNewTaskPage(ModelMap model) {
        String username = (String)model.get("username");
        TasksList TasksList = new TasksList(0, username, "", LocalDate.now(), false);
        model.addAttribute("TasksList", TasksList);
        return "newtasks";
    }

    @RequestMapping(value="newtasks", method = RequestMethod.POST)
    public String createNewTask(ModelMap model, @ModelAttribute @Valid TasksList TasksList, BindingResult result) {

        if (result.hasErrors()){
            model.addAttribute("errorMessage", "Enter at least 5-20 characters!");
            return "newtasks";
        }

        String username = (String)model.get("username");
        com.example.projeto.TasksListService.newtasks(username, TasksList.getDescription(), LocalDate.now(), false);
        return "welcome";
    }

    @GetMapping("deleteTask{id}")
    public String deleteTask(@PathVariable int id) {
        tasksListService.deleteById(id);
        return "welcome";
    }
}