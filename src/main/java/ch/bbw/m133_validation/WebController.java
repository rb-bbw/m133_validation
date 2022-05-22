package ch.bbw.m133_validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class WebController implements WebMvcConfigurer {
    static Logger log = Logger.getLogger("WebController");

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("personForm", new PersonForm());
        return "form";
    }
    @PostMapping("/")
    public String checkPersonInfo(
            Model model,
            @Valid PersonForm personForm,
            BindingResult bindingResult // validation results
    ) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        model.addAttribute("personForm", personForm);
        return "results";
    }

    @GetMapping("/results")
    public String showResults(Model model) {
        return "results";
    }
}