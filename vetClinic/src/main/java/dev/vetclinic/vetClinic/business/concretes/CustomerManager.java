package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.ICustomerService;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.exception.NotFoundException;
import dev.vetclinic.vetClinic.core.exception.recordAlreadyExistException;
import dev.vetclinic.vetClinic.core.exception.recordNotFoundWithIdException;
import dev.vetclinic.vetClinic.entities.Customer;
import dev.vetclinic.vetClinic.repo.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {

    private final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer save(Customer customer) {
        if (customerRepo.findByName(customer.getName()) != null) {
            throw new recordAlreadyExistException(customer.getId());
        }
        return customerRepo.save(customer);
    }

    @Override
    public Customer get(Long id) {
        return this.customerRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Customer getByName(String name) {
        Customer customer;
        try {
            customer = this.customerRepo.findByName(name);
            if (customer == null) {
                throw new NotFoundException(Msg.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        if (this.get(customer.getId()) == null) {
            throw new recordNotFoundWithIdException(customer.getId());
        }
        return this.customerRepo.save(customer);
    }

    @Override
    public boolean delete(Long id) {
        Customer customer = this.get(id);
        if (customer == null) {
            throw new recordNotFoundWithIdException(id);
        }
        this.customerRepo.delete(customer);
        return true;
    }
}
