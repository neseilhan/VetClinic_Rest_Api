package dev.vetclinic.vetClinic.business.abstracts;

import dev.vetclinic.vetClinic.entities.Animal;
import dev.vetclinic.vetClinic.entities.Customer;

import java.util.List;

public interface IAnimalService {

    Animal save(Animal animal);

    Animal get(Long id);

    Animal getByName(String name);

    Customer getByCustomerName(String name);

    Animal update(Animal animal);

    boolean delete(Long id);

    List<Animal> findAll();

}
