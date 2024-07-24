package dev.vetclinic.vetClinic.api;

import dev.vetclinic.vetClinic.business.abstracts.ICustomerService;
import dev.vetclinic.vetClinic.core.config.Result;
import dev.vetclinic.vetClinic.core.config.ResultData;
import dev.vetclinic.vetClinic.core.config.ResultHelper;
import dev.vetclinic.vetClinic.core.exception.NotFoundException;
import dev.vetclinic.vetClinic.core.exception.recordAlreadyExistException;
import dev.vetclinic.vetClinic.core.modelMapper.IModelMapperService;
import dev.vetclinic.vetClinic.dto.request.CustomerSaveRequest;
import dev.vetclinic.vetClinic.dto.response.AnimalResponse;
import dev.vetclinic.vetClinic.dto.response.CustomerResponse;
import dev.vetclinic.vetClinic.entities.Animal;
import dev.vetclinic.vetClinic.entities.Customer;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final ICustomerService customerService;
    private final IModelMapperService modelMapper;

    public CustomerController(ICustomerService customerService, IModelMapperService modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CustomerResponse> save(@Valid @RequestBody CustomerSaveRequest customerSaveRequest) {
        // Convert the request DTO to the entity
        Customer customer = modelMapper.forRequest().map(customerSaveRequest, Customer.class);

        try {
            // Save the animal entity
            Customer saveCustomer = customerService.save(customer);
//            saveCustomer.setId(0L);
            // Convert the saved entity to response DTO
            CustomerResponse customerResponse = this.modelMapper.forResponse().map(saveCustomer, CustomerResponse.class);
            return ResultHelper.created(customerResponse);
        } catch (recordAlreadyExistException e) {
            // Handle case where record already exists
            return ResultHelper.recordAlreadyExistsError(e.getId(), CustomerResponse.class);
        }
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> getById(@PathVariable("id") Long id) {
        Customer customer = customerService.get(id);
        CustomerResponse customerResponse = modelMapper.forResponse().map(customer, CustomerResponse.class);
        return ResultHelper.success(customerResponse);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> getByName(@PathVariable("name") String name) {
        Customer customer = customerService.getByName(name);
        CustomerResponse customerResponse = modelMapper.forResponse().map(customer, CustomerResponse.class);
        return ResultHelper.success(customerResponse);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CustomerResponse> update(@PathVariable("id") Long id, @Valid @RequestBody CustomerSaveRequest customerSaveRequest) {
        Customer customer = modelMapper.forResponse().map(customerSaveRequest, Customer.class);
        customer.setId(id); // Ensure the customer has the correct ID
        Customer updatedCustomer = customerService.update(customer);
        CustomerResponse customerResponse = modelMapper.forResponse().map(updatedCustomer, CustomerResponse.class);
        return ResultHelper.success(customerResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") Long id) {
        try {
            this.customerService.delete(id);
        } catch (NotFoundException e) {
            // Kayıt bulunamadığında uygun HTTP durum kodunu döndürür
            return ResultHelper.recordNotFoundWithId(id);
        }

        return ResultHelper.ok();
    }
}