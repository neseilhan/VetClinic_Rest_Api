package dev.vetclinic.vetClinic.repo;

import dev.vetclinic.vetClinic.entities.AvailableDate;
import dev.vetclinic.vetClinic.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Long> {

    Optional<AvailableDate> findByDoctorAndAvailableDate(Doctor doctor, LocalDate availableDate);

    boolean existsByDoctorAndAvailableDate(Doctor doctor, LocalDate availableDate);
}
