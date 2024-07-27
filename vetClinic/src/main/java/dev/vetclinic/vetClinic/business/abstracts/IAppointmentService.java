package dev.vetclinic.vetClinic.business.abstracts;

import dev.vetclinic.vetClinic.entities.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentService {

    Appointment save(Appointment appointment);

    Appointment update(Appointment appointment);

    Appointment get(Long id);

    boolean delete(Long id);

    //Jpa ' nın Between findByBetween kullanimi.
    List<Appointment> findByAnimalAndDateBetween(LocalDate startDate, LocalDate endDate, String animalName);
}
