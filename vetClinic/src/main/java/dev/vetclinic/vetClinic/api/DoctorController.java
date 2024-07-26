package dev.vetclinic.vetClinic.api;

import dev.vetclinic.vetClinic.business.concretes.DoctorManager;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.config.Result;
import dev.vetclinic.vetClinic.core.config.ResultData;
import dev.vetclinic.vetClinic.core.config.ResultHelper;
import dev.vetclinic.vetClinic.core.exception.recordAlreadyExistException;
import dev.vetclinic.vetClinic.core.modelMapper.IModelMapperService;
import dev.vetclinic.vetClinic.dto.request.DoctorSaveRequest;
import dev.vetclinic.vetClinic.dto.request.DoctorUpdateRequest;
import dev.vetclinic.vetClinic.dto.response.AnimalResponse;
import dev.vetclinic.vetClinic.dto.response.DoctorResponse;
import dev.vetclinic.vetClinic.entities.Doctor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorManager doctorService;
    private final IModelMapperService modelMapper;

    public DoctorController(DoctorManager doctorService, IModelMapperService modelMapper) {
        this.doctorService = doctorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DoctorResponse> save (@Valid @RequestBody DoctorSaveRequest doctorSaveRequest){
        // Convert the request DTO to the entity
        Doctor doctor = modelMapper.forRequest().map(doctorSaveRequest, Doctor.class);

        try {
            // Save the animal entity
            Doctor savedDoctor = doctorService.save(doctor);
            // Convert the saved entity to response DTO
            DoctorResponse doctorResponse  = this.modelMapper.forResponse().map(savedDoctor, DoctorResponse.class);
            return ResultHelper.created(doctorResponse);
        } catch (recordAlreadyExistException e) {
            // Fetch the existing animal entity
            Doctor existingDoctor = doctorService.get(e.getId());
            // Convert the existing entity to response DTO
            DoctorResponse existingDoctorResponse = this.modelMapper.forResponse().map(existingDoctor, DoctorResponse.class);
            // Handle case where record already exists
            return ResultHelper.recordAlreadyExistsError(e.getId(), existingDoctorResponse);
        }
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<DoctorResponse> getByName(@PathVariable("name") String name){
        Doctor doctor = this.doctorService.getByName(name);
        DoctorResponse doctorResponse = this.modelMapper
                .forResponse()
                .map(doctor,DoctorResponse.class);
        return ResultHelper.success(doctorResponse);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<DoctorResponse> update(@Valid @RequestBody DoctorUpdateRequest doctorUpdateRequest){
        Doctor updateDoctor = this.modelMapper.forRequest().map(doctorUpdateRequest, Doctor.class);
        this.doctorService.save(updateDoctor);
        DoctorResponse doctorResponse = this.modelMapper.forResponse().map(updateDoctor, DoctorResponse.class);
        return ResultHelper.created(doctorResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.doctorService.delete(id);
        return ResultHelper.success(Msg.OK);
    }
}
