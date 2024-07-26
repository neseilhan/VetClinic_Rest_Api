package dev.vetclinic.vetClinic.repo;

import dev.vetclinic.vetClinic.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByEndDateBetween(LocalDate startDate, LocalDate endDate);
    List<Vaccine> findByAnimalId(Long animalId);
    List<Vaccine> findByNameAndCode(String name, String code);
}
