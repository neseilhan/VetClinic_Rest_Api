package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.IAvailableDateService;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.exception.NotFoundException;
import dev.vetclinic.vetClinic.core.exception.recordAlreadyExistException;
import dev.vetclinic.vetClinic.core.exception.recordNotFoundWithIdException;
import dev.vetclinic.vetClinic.core.modelMapper.IModelMapperService;
import dev.vetclinic.vetClinic.entities.Animal;
import dev.vetclinic.vetClinic.entities.AvailableDate;
import dev.vetclinic.vetClinic.repo.AvailableDateRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AvailableDateManager implements IAvailableDateService {

    private final AvailableDateRepo availableDateRepository;

    public AvailableDateManager(AvailableDateRepo availableDateRepository) {
        this.availableDateRepository = availableDateRepository;
    }

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        // Check if an AvailableDate already exists for the given doctor and date
        Optional<AvailableDate> existingAvailableDate = availableDateRepository.findByDoctorAndAvailableDate(
                availableDate.getDoctor(), availableDate.getAvailableDate());

        if (existingAvailableDate.isPresent()) {
            throw new recordAlreadyExistException(existingAvailableDate.get().getId());
        }
        return this.availableDateRepository.save(availableDate);
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {
        if (this.get(availableDate.getId()) == null) {
            throw new recordNotFoundWithIdException(availableDate.getId());
        }
        return this.availableDateRepository.save(availableDate);
    }

    @Override
    public AvailableDate get(Long id) {
        return this.availableDateRepository.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(Long id) {
        AvailableDate availableDate = this.get(id);
        if (availableDate == null) {
            throw new recordNotFoundWithIdException(id);
        }
        this.availableDateRepository.delete(availableDate);
        return true;
    }
}
