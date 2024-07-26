package dev.vetclinic.vetClinic.dto.request;

import dev.vetclinic.vetClinic.entities.Doctor;
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
public class AvailableDateUpdateRequest {

    @Positive(message = "Id must be a positive number.")
    @NotNull
    private Long id;

    @NotNull(message = "Date field can not be null.")
    private LocalDate availableDate;

    @NotNull(message = "Doctor field can not be null.")
    private Doctor doctor;
}
