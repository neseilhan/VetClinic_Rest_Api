package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.IVaccineService;
import dev.vetclinic.vetClinic.entities.Vaccine;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VaccineManager implements IVaccineService {
    @Override
    public Vaccine save(Vaccine vaccine) {
        return null;
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        return null;
    }

    @Override
    public Vaccine get(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public Vaccine getById(long id) {
        return null;
    }

    @Override
    public List<Vaccine> getVaccinationsByAnimalName(String animalName) {
        return List.of();
    }

    @Override
    public List<Vaccine> getVaccinationsExpiringBetween(LocalDate startDate, LocalDate endDate) {
        return List.of();
    }
}
