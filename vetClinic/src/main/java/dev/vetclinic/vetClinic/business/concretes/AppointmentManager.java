package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.IAppointmentService;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.config.Result;
import dev.vetclinic.vetClinic.core.config.ResultHelper;
import dev.vetclinic.vetClinic.core.exception.NotFoundException;
import dev.vetclinic.vetClinic.core.exception.appointmentAlreadyExistException;
import dev.vetclinic.vetClinic.core.exception.appointmentHoursException;
import dev.vetclinic.vetClinic.entities.Appointment;
import dev.vetclinic.vetClinic.entities.Doctor;
import dev.vetclinic.vetClinic.repo.AppointmentRepo;
import dev.vetclinic.vetClinic.repo.AvailableDateRepo;
import dev.vetclinic.vetClinic.repo.DoctorRepo;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentManager implements IAppointmentService {

    private final AppointmentRepo appointmentRepository;
    private final AvailableDateRepo availableDateRepository;
    private final DoctorRepo doctorRepository;

    public AppointmentManager(AppointmentRepo appointmentRepository, AvailableDateRepo availableDateRepository, DoctorRepo doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.availableDateRepository = availableDateRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        Doctor doctor = doctorRepository.findById(appointment.getDoctor().getId())
                .orElseThrow(() -> new NotFoundException((Msg.NOT_FOUND)));

        appointment.setDoctor(doctor);

        boolean hasExactAppointment = appointmentRepository.existsByDoctorAndAppointmentDateAndAppointmentTime(
                appointment.getDoctor(), appointment.getAppointmentDate(), appointment.getAppointmentTime());

        if (hasExactAppointment) { //?
            throw new appointmentAlreadyExistException(Msg.APPOINTMENT_ALREADY_EXISTS);
        }
        List<Appointment> existingAppointments = appointmentRepository.findByDoctorAndAppointmentDate(
                appointment.getDoctor(), appointment.getAppointmentDate());

        for (Appointment existingAppointment : existingAppointments) {
            long timeDifference = Math.abs(Duration.between(existingAppointment.getAppointmentTime(), appointment.getAppointmentTime()).toHours());
            if (timeDifference < 1) {
                throw new appointmentHoursException(Msg.APPOINTMENT_ERROR);
            }
            boolean isAvailableDate = availableDateRepository.existsByDoctorAndAvailableDate(
                    appointment.getDoctor(), appointment.getAppointmentDate());

            if (!isAvailableDate) {
                throw new appointmentAlreadyExistException(Msg.APPOINTMENT_ALREADY_EXISTS);
            }
        }
        return this.appointmentRepository.save(appointment);

    }



    @Override
    public Appointment update(Appointment appointment) {
        this.get(appointment.getId());
        return this.appointmentRepository.save(appointment);
    }

    @Override
    public Appointment get(Long id) {
        return this.appointmentRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(Long id) {
        Appointment appointment = this.get(id);
        this.appointmentRepository.delete(appointment);
        return true;
    }

    @Override
    public List<Appointment> findByAnimalAndDateBetween(LocalDate startDate, LocalDate endDate, String animalName) {
        return appointmentRepository.findByAppointmentDateBetweenAndAnimalName(startDate, endDate, animalName);
    }

}
