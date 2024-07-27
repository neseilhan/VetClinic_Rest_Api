package dev.vetclinic.vetClinic.dto.response;

import dev.vetclinic.vetClinic.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {

    private Long id;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private Doctor doctor;

}
