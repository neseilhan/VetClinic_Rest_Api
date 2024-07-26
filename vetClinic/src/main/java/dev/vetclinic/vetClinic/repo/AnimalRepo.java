package dev.vetclinic.vetClinic.repo;

import dev.vetclinic.vetClinic.entities.Animal;
import dev.vetclinic.vetClinic.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepo extends JpaRepository <Animal, Long> {

    Animal findByName(String name);
//     List<Animal> findByName(String name);

    Customer findByCustomerName(String name);
}
