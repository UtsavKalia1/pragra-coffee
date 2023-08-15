package co.pragra.pragracofeetime.service;

import co.pragra.pragracofeetime.entity.Customer;
import co.pragra.pragracofeetime.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    public Customer addCustomer(Customer c){
    repository.save(c);
    return c;
    }
    public List<Customer> fetchAllCustomer(){
      return repository.findAll();
    }
    public void delCustomer(Customer c){
        repository.delete(c);
    }

}
