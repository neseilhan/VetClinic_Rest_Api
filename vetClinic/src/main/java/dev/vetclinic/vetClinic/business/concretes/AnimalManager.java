package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.IAnimalService;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.exception.NotFoundException;
import dev.vetclinic.vetClinic.core.exception.recordAlreadyExistException;
import dev.vetclinic.vetClinic.core.exception.recordNotFoundWithIdException;
import dev.vetclinic.vetClinic.entities.Animal;
import dev.vetclinic.vetClinic.entities.Customer;
import dev.vetclinic.vetClinic.repo.AnimalRepo;
import dev.vetclinic.vetClinic.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalManager implements IAnimalService {

    private final AnimalRepo animalRepo;
    private final CustomerRepo customerRepo;

    public AnimalManager(AnimalRepo animalRepo, CustomerRepo customerRepo) {
        this.animalRepo = animalRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public Animal save(Animal animal) {
        Animal existingAnimal = animalRepo.findByName(animal.getName());
        if (existingAnimal != null) {
            // Eğer mevcut hayvan varsa hata
            throw new recordAlreadyExistException(existingAnimal.getId());
        }
        animal.setId(null);
        return animalRepo.save(animal);
    }

    public Animal findById(Long id) {
        return animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Animal get(Long id) {
        return this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Animal getByName(String name) {
        Animal animal;
        try {
            animal = this.animalRepo.findByName(name);
            if (animal == null) {
                throw new NotFoundException(Msg.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        return animal;
    }
    @Override
    public Customer getByCustomerName(String name) {
        Customer customer;
        try {
            customer = this.animalRepo.findByCustomerName(name);
            if (customer == null) {
                throw new NotFoundException(Msg.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        return customer;
    }
    @Override
    public List<Animal> findAll() {
        return animalRepo.findAll();
    }

    @Override
    public Animal update(Animal animal) {
        if (this.get(animal.getId()) == null) {
            throw new recordNotFoundWithIdException(animal.getId());
        }
        return this.animalRepo.save(animal);
    }

    @Override
    public boolean delete(Long id) {
        Animal animal = this.get(id);
        if (animal == null) {
            throw new recordNotFoundWithIdException(id);
        }
        this.animalRepo.delete(animal);
        return true;
    }
}
