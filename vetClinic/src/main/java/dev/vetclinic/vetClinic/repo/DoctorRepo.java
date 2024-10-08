package dev.vetclinic.vetClinic.repo;

import dev.vetclinic.vetClinic.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Doctor findByName(String name);
}
