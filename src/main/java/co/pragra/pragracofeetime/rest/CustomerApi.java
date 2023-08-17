package co.pragra.pragracofeetime.rest;

import co.pragra.pragracofeetime.entity.Customer;
import co.pragra.pragracofeetime.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerApi {
    private final CustomerService service;
    @GetMapping("/customer")
    public List<Customer> getAll(){
        return service.getAll();
    }
    @GetMapping("/customer/name")
    public List<Customer> getAllLastName(@RequestParam(value = "lastName", required = false) String lastName ){
        return service.getAllLastName(Optional.ofNullable(lastName));
    }
    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomer(@PathVariable int id){
        return service.getById(id);
    }
    @PostMapping("/customer")
    public Customer create(@RequestBody Customer customer){
        return this.service.createCustomer(customer);
    }
}
