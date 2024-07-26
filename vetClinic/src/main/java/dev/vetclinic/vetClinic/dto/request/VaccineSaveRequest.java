package dev.vetclinic.vetClinic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineSaveRequest {

    @NotNull(message = "Vaccine name can not be null.")
    private String name;

    private String code;

    @NotNull(message = "Protection start date can not be null.")
    private LocalDate startDate;

    @NotNull(message = "Protection end date can not be null.")
    private LocalDate endDate;

    @NotNull(message = "Animal ID can not be null.")
    private Long animalId;
}
