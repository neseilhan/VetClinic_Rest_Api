package dev.vetclinic.vetClinic.business.concretes;

import dev.vetclinic.vetClinic.business.abstracts.IDoctorService;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.exception.NotFoundException;
import dev.vetclinic.vetClinic.core.exception.recordAlreadyExistException;
import dev.vetclinic.vetClinic.core.exception.recordNotFoundWithIdException;
import dev.vetclinic.vetClinic.entities.Animal;
import dev.vetclinic.vetClinic.entities.Customer;
import dev.vetclinic.vetClinic.entities.Doctor;
import dev.vetclinic.vetClinic.repo.DoctorRepo;
import org.springframework.stereotype.Service;

@Service
public class DoctorManager implements IDoctorService {
    private final DoctorRepo doctorRepo;

    public DoctorManager(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor save(Doctor doctor) {
        Doctor existingDoctor = doctorRepo.findByName(doctor.getName());
        if (existingDoctor != null) {
            // Eğer mevcut doktor varsa hata
            throw new recordAlreadyExistException(existingDoctor.getId());
        }
        doctor.setId(null);
        return doctorRepo.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        if (this.get(doctor.getId()) == null) {
            throw new recordNotFoundWithIdException(doctor.getId());
        }
        return this.doctorRepo.save(doctor);
    }

    @Override
    public Doctor get(Long id) {
        return this.doctorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(Long id) {
        Doctor doctor = this.get(id);
        if (doctor == null) {
            throw new recordNotFoundWithIdException(id);
        }
        this.doctorRepo.delete(doctor);
        return true;
    }

    @Override
    public Doctor getByName(String name) {
        return this.doctorRepo.findByName(name);
    }
}
