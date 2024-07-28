package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.IVaccineService;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.config.Result;
import dev.vetclinic.vetClinic.core.config.ResultData;
import dev.vetclinic.vetClinic.core.config.ResultHelper;
import dev.vetclinic.vetClinic.core.exception.*;
import dev.vetclinic.vetClinic.dto.response.VaccineResponse;
import dev.vetclinic.vetClinic.entities.Animal;
import dev.vetclinic.vetClinic.entities.Vaccine;
import dev.vetclinic.vetClinic.repo.VaccineRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;
    private final AnimalManager animalService;

    public VaccineManager(VaccineRepo vaccineRepo, AnimalManager animalService) {
        this.vaccineRepo = vaccineRepo;
        this.animalService = animalService;
    }


    @Override
    public Vaccine save(Vaccine vaccine) {
        if (vaccine.getEndDate().isBefore(LocalDate.now())) {
                throw new VaccineNotApplicableException(Msg.DATE_ERROR);
            }
        List<Vaccine> existingVaccineList = this.vaccineRepo.findByNameAndCode(
                vaccine.getName(),
                vaccine.getCode()
//                vaccine.getAnimal().getId()
        );
        for(Vaccine existingVaccine : existingVaccineList){
            if(existingVaccine.getCode().equals(vaccine.getCode()) && existingVaccine.getName().equals(vaccine.getName())){
                throw new VaccineNotApplicableException(Msg.DATE_ERROR);
            }
        }
        // Yeni aşı kaydı oluşturulurken ID'nin null olduğundan emin olun
        vaccine.setId(null);

        // Aşı nesnesinin hayvanını doğrula ve ata
        Animal animal = this.animalService.get(vaccine.getAnimal().getId());
        vaccine.setAnimal(animal);

        // Aşıyı kaydet ve geri dön
        return this.vaccineRepo.save(vaccine);
    }

    public List<Vaccine> getByAnimalId(Long animalId) {
//        return vaccineRepo.findByAnimalId(animalId);
        //NotFoundException da olabilir.
        List<Vaccine> vaccines = vaccineRepo.findByAnimalId(animalId);
        if (vaccines.isEmpty()) {
            throw new recordNotFoundWithIdException(animalId);
        }
        return vaccines;
    }

    @Override
    public List<Vaccine> getVaccinesByEndDateBetween(LocalDate startDate, LocalDate endDate) {
        //        return vaccineRepo.findByEndDateBetween(startDate, endDate);
        List<Vaccine> vaccines = vaccineRepo.findByEndDateBetween(startDate, endDate);
        if (vaccines.isEmpty()) {
            throw new NotFoundException(Msg.VACCINE_NULL);
        }
        return vaccines;
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        this.get(vaccine.getId());
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public Vaccine get(Long id) {
        return vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(Long id) {
        Vaccine vaccine = this.get(id);
        if (vaccine == null) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        this.vaccineRepo.delete(vaccine);
        return true;
    }


}
