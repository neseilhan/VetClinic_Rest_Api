package dev.vetclinic.vetClinic.business.abstracts;

import dev.vetclinic.vetClinic.entities.Customer;

public interface ICustomerService {

    Customer save(Customer customer);

    Customer update(Customer customer);

    Customer get(Long id);

    boolean delete(Long id);

    Customer getByName(String name);
}
