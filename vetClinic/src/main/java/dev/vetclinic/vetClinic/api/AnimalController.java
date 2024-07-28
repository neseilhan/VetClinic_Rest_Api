package dev.vetclinic.vetClinic.api;

import dev.vetclinic.vetClinic.business.abstracts.IAnimalService;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.config.Result;
import dev.vetclinic.vetClinic.core.config.ResultData;
import dev.vetclinic.vetClinic.core.config.ResultHelper;
import dev.vetclinic.vetClinic.core.exception.NotFoundException;
import dev.vetclinic.vetClinic.core.exception.recordAlreadyExistException;
import dev.vetclinic.vetClinic.core.exception.recordNotFoundWithIdException;
import dev.vetclinic.vetClinic.core.modelMapper.IModelMapperService;
import dev.vetclinic.vetClinic.dto.request.AnimalSaveRequest;
import dev.vetclinic.vetClinic.dto.request.AnimalUpdateRequest;
import dev.vetclinic.vetClinic.dto.response.AnimalResponse;
import dev.vetclinic.vetClinic.dto.response.CustomerResponse;
import dev.vetclinic.vetClinic.entities.Animal;
import dev.vetclinic.vetClinic.entities.Customer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final IAnimalService animalService;
    private final IModelMapperService modelMapper;

    //Dependency injection here.
    public AnimalController(IAnimalService animalService, IModelMapperService modelMapper) {
        this.animalService = animalService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AnimalResponse> save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest) {
        // Convert the request DTO to the entity
        Animal animal = modelMapper.forRequest().map(animalSaveRequest, Animal.class);

        try {
            // Save the animal entity
            Animal savedAnimal = animalService.save(animal);
            // Convert the saved entity to response DTO
            AnimalResponse animalResponse = this.modelMapper.forResponse().map(savedAnimal, AnimalResponse.class);
            return ResultHelper.created(animalResponse);
        } catch (recordAlreadyExistException e) {
            // Fetch the existing animal entity
            Animal existingAnimal = animalService.get(e.getId());
            // Convert the existing entity to response DTO
            AnimalResponse existingAnimalResponse = this.modelMapper.forResponse().map(existingAnimal, AnimalResponse.class);
            // Handle case where record already exists
            return ResultHelper.recordAlreadyExistsError(e.getId(), existingAnimalResponse);
        }
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AnimalResponse>> getAll() {
        List<Animal> animals = this.animalService.findAll();
        List<AnimalResponse> animalResponses = animals.stream()
                .map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class))
                .toList();
        return ResultHelper.success(animalResponses);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> getById(@PathVariable("id") Long id) {
        Animal animal = this.animalService.get(id);
        AnimalResponse animalResponse = this.modelMapper.forResponse().map(animal, AnimalResponse.class);
        return ResultHelper.success(animalResponse);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AnimalResponse> getByName(@PathVariable("name") String name) {
        Animal animal = this.animalService.getByName(name);
        AnimalResponse animalResponse = this.modelMapper.forResponse().map(animal, AnimalResponse.class);
        return ResultHelper.success(animalResponse);
    }

    @GetMapping("/customerName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> getByCustomerName(@PathVariable("name") String name) {
        Customer customer = this.animalService.getByCustomerName(name);
        CustomerResponse customerResponse = this.modelMapper.forResponse().map(customer, CustomerResponse.class);
        return ResultHelper.success(customerResponse);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result update(@PathVariable("id") Long id, @RequestBody Animal animal) {
        try {
            animal.setId(id); // Ensure the ID from the path is used
            animalService.update(animal);
        } catch (recordNotFoundWithIdException e) {
            // Record not found, return a 404 error using existing method
            return ResultHelper.recordNotFoundWithId(id);
        } catch (Exception e) {
            // Handle other exceptions if needed
            return new Result("500", "Internal server error", false);
        }
        return ResultHelper.ok();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") Long id) {
        try {
            this.animalService.delete(id);
        } catch (NotFoundException e) {
            return ResultHelper.recordNotFoundWithId(id);
        }
        return ResultHelper.ok();
    }

}
