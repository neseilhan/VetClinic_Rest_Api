package dev.vetclinic.vetClinic.dto.request;

import dev.vetclinic.vetClinic.entities.Animal;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineUpdateRequest {

    @Positive(message = "ID should be positive number")
    @NotNull
    private Long id;

    private String name;

    private String code;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long  animalId;
}
