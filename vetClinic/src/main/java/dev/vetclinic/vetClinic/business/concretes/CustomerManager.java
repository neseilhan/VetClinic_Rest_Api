package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.ICustomerService;
import dev.vetclinic.vetClinic.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {
    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public Customer get(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public Customer getByName(String name) {
        return null;
    }
}
