package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.IDoctorService;
import dev.vetclinic.vetClinic.entities.Doctor;
import org.springframework.stereotype.Service;

@Service
public class DoctorManager implements IDoctorService {
    @Override
    public Doctor save(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor update(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor get(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public Doctor getByName(String name) {
        return null;
    }
}
