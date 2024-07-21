package dev.vetclinic.vetClinic.business.abstracts;

import dev.vetclinic.vetClinic.entities.AvailableDate;

public interface IAvailableDateService {

    AvailableDate save(AvailableDate availableDate);

    AvailableDate update(AvailableDate availableDate);

    AvailableDate get(long id);

    boolean delete(long id);
}
