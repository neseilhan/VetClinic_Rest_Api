package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.IAvailableDateService;
import dev.vetclinic.vetClinic.entities.AvailableDate;
import org.springframework.stereotype.Service;

@Service
public class AvailableDateManager implements IAvailableDateService {
    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return null;
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {
        return null;
    }

    @Override
    public AvailableDate get(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
