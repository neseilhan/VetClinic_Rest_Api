package dev.vetclinic.vetClinic.business.abstracts;

import dev.vetclinic.vetClinic.entities.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {

    Vaccine save(Vaccine vaccine);

    Vaccine update(Vaccine vaccine);

    Vaccine get(long id);

    boolean delete(long id);

    Vaccine getById(long id);

    List<Vaccine> getVaccinationsByAnimalName(String animalName);

    List<Vaccine> getVaccinationsExpiringBetween(LocalDate startDate, LocalDate endDate);
}
