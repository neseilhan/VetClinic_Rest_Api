package dev.vetclinic.vetClinic.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalSaveRequest {
    @NotNull(message = "Customer name can not be null.")
    @NotEmpty
    private String name;

    private String species;

    private String breed;

    private String gender;

    private String color;

    private LocalDate birthDate;

    @NotNull(message = "Customer id can not be null.")
    private long customerId;
}
