package co.pragra.pragracofeetime.service;

import co.pragra.pragracofeetime.entity.Customer;
import co.pragra.pragracofeetime.exceptions.InvalidCustomerException;
import co.pragra.pragracofeetime.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    @Autowired
    private final CustomerRepository repository;
    public Customer createCustomer(Customer c){
        if (c.getFirstName() == null  || c.getFirstName().isEmpty()){
            throw new InvalidCustomerException("Customer first name can't null or blank");
        }
        return this.repository.save(c);
    }
    public List<Customer> fetchAllCustomer(){
      return repository.findAll();
    }

    public Customer updateCustomer(Customer c){
        if (c.getId()==null || c.getId() <=0){
            throw new InvalidCustomerException("Invalid ID");
        }
        Optional<Customer> optional = repository.findById(c.getId());
        Customer cust = optional.orElseThrow(() -> new InvalidCustomerException("invalid id"));
        if (c.getFirstName() == null  || c.getFirstName().isEmpty()){
            throw new InvalidCustomerException("Customer first name can't null or blank");
        }
        return this.repository.save(c);
    }
    public List<Customer> getAll(){
        return this.repository.findAll();
    }
    public Optional<Customer> getById(int id){
        return this.repository.findById(id);
    }
    public void delCustomer(int id){
        this.repository.findById(id);
        this.repository.deleteById(id);
    }
    public List<Customer> getAllLastName(Optional<String> lastName){
        if (lastName.isPresent()){
            return this.repository.findAllByLastName(lastName.get());
        }
        return this.repository.findAll();
    }

}
