package dev.vetclinic.vetClinic.business.abstracts;

import dev.vetclinic.vetClinic.entities.Doctor;

public interface IDoctorService {

    Doctor save(Doctor doctor);

    Doctor update(Doctor doctor);

    Doctor get(Long id);

    boolean delete(Long id);

    Doctor getByName(String name);

}
