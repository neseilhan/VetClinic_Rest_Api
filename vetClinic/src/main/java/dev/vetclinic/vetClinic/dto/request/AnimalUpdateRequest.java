package dev.vetclinic.vetClinic.dto.request;

import dev.vetclinic.vetClinic.entities.Customer;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalUpdateRequest {
    @Positive(message = "ID should be positive.")
    private long id;

    @NotNull(message = "Customer name can not be null.")
    @NotEmpty
    private String name;

    private String species;

    private String breed;

    private String gender;

    private LocalDate birthDate;

    @NotNull(message = "Customer name cannot be null.")
    private Customer customer;
}