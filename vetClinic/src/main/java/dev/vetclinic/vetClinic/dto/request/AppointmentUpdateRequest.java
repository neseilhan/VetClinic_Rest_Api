package dev.vetclinic.vetClinic.dto.request;

import dev.vetclinic.vetClinic.entities.Animal;
import dev.vetclinic.vetClinic.entities.Doctor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {

    @Positive(message = "Id must be a positive number.")
    @NotNull
    private Long id;

    @NotNull(message = "Appointment date can not be null.")
    private LocalDate appointmentDate;

    @NotNull(message = "Appointment time can not be null.")
    private LocalTime appointmentTime;

    @NotNull(message = "Doctor field can not be null.")
    private Doctor doctor;

    @NotNull(message = "Animal field can not be null.")
    private Animal animal;
}
