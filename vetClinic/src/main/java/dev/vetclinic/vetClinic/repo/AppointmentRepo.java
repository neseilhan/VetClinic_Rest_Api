package dev.vetclinic.vetClinic.repo;

import dev.vetclinic.vetClinic.entities.Appointment;
import dev.vetclinic.vetClinic.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorAndAppointmentDate(Doctor doctor, LocalDate appointmentDate);

    boolean existsByDoctorAndAppointmentDateAndAppointmentTime(Doctor doctor, LocalDate appointmentDate, LocalTime appointmentTime);

    List<Appointment> findByAppointmentDateBetweenAndAnimalName(LocalDate startDate, LocalDate endDate, String animalName);


}
