package dev.vetclinic.vetClinic.dto.request;

import dev.vetclinic.vetClinic.entities.Doctor;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentSaveRequest {
    @NotNull(message = "Appointment date can not be null.")
    private LocalDate appointmentDate;

    @NotNull(message = "Appointment time can not be null.")
    private LocalTime appointmentTime;

    @NotNull(message = "Doctor field can not be null.")
    private Long doctorId;

    @NotNull(message = "Animal field can not be null.")
    private Long animalId;
}
