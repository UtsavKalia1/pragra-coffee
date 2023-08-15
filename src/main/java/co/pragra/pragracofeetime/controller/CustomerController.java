package co.pragra.pragracofeetime.controller;

import co.pragra.pragracofeetime.entity.Customer;
import co.pragra.pragracofeetime.repo.CustomerRepository;
import co.pragra.pragracofeetime.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService service;
    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customer/create")
    public String getCreateCustomer(Model model){
        model.addAttribute("pageTitle", "Create A Customer / Pragra CoffeeTime");
        model.addAttribute("customer",new Customer());

        return "create-customer";
    }

    @PostMapping("/customer/create")
    public String create(@ModelAttribute Customer customer, Model model){
        service.addCustomer(customer);
        //repository.save(customer);
      //  model.addAttribute("customers",repository.findAll());
        model.addAttribute("customers",service.fetchAllCustomer());
        System.out.println("customers "+ customer);
        return "customer";
    }
    @GetMapping("/customer/delete")
    public String delete(@ModelAttribute Customer customer, Model model){
        repository.delete(customer);
        return "customer";
    }
}
