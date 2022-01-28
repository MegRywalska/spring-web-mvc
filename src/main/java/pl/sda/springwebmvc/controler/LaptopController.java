package pl.sda.springwebmvc.controler;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.springwebmvc.model.Laptop;

@Controller
@RequestMapping(value = "laptop")
public class LaptopController {

    @GetMapping("/add-laptop-form")
    public String showAddLaptopForm(Model model){

        model.addAttribute("laptop" , Laptop.builder().build());
        return "/laptop/add-laptop-form";
    }

    @PostMapping(value = "add")
    public String addBook(Laptop laptop){
        return "redirect:/";
    }
}
