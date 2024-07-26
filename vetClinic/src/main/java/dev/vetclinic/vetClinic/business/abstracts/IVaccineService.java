package dev.vetclinic.vetClinic.business.abstracts;

import dev.vetclinic.vetClinic.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {

    Vaccine save(Vaccine vaccine);

    Vaccine update(Vaccine vaccine);

    Vaccine get(Long id);

    boolean delete(Long id);

    List<Vaccine> getByAnimalId(Long animalId);

    List<Vaccine> getVaccinesByEndDateBetween(LocalDate startDate, LocalDate endDate);

}
