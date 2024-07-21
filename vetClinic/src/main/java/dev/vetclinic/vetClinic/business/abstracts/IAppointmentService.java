package dev.vetclinic.vetClinic.business.abstracts;

import dev.vetclinic.vetClinic.entities.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentService {

    Appointment save(Appointment appointment);

    Appointment update(Appointment appointment);

    Appointment get(long id);

    boolean delete(long id);

    //Jpa ' nın Between findByBetween kullanimi.
    List<Appointment> findByDoctorAndDateBetween(LocalDate startDate, LocalDate endDate, String animalName);
}
