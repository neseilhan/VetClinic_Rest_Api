package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.IAppointmentService;
import dev.vetclinic.vetClinic.entities.Appointment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentManager implements IAppointmentService {
    @Override
    public Appointment save(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment update(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment get(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Appointment> findByDoctorAndDateBetween(LocalDate startDate, LocalDate endDate, String animalName) {
        return List.of();
    }
}
