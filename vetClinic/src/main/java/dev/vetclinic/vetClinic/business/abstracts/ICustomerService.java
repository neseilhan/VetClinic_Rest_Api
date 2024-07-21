package dev.vetclinic.vetClinic.business.abstracts;

import dev.vetclinic.vetClinic.entities.Customer;

public interface ICustomerService {

    Customer save(Customer customer);

    Customer update(Customer customer);

    Customer get(long id);

    boolean delete(long id);

    Customer getByName(String name);
}
