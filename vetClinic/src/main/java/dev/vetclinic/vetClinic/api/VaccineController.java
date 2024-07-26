package dev.vetclinic.vetClinic.api;

import dev.vetclinic.vetClinic.business.abstracts.IVaccineService;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.config.Result;
import dev.vetclinic.vetClinic.core.config.ResultData;
import dev.vetclinic.vetClinic.core.config.ResultHelper;
import dev.vetclinic.vetClinic.core.exception.NotFoundException;
import dev.vetclinic.vetClinic.core.exception.VaccineNotApplicableException;
import dev.vetclinic.vetClinic.core.exception.recordAlreadyExistException;
import dev.vetclinic.vetClinic.core.exception.recordNotFoundWithIdException;
import dev.vetclinic.vetClinic.core.modelMapper.IModelMapperService;
import dev.vetclinic.vetClinic.dto.request.VaccineSaveRequest;
import dev.vetclinic.vetClinic.dto.response.CustomerResponse;
import dev.vetclinic.vetClinic.dto.response.VaccineResponse;
import dev.vetclinic.vetClinic.entities.Vaccine;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vaccines")
public class VaccineController {

    private final IVaccineService vaccineService;
    private final IModelMapperService modelMapper;

    public VaccineController(IVaccineService vaccineService, IModelMapperService modelMapper) {
        this.vaccineService = vaccineService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<VaccineResponse> save(@Valid @RequestBody VaccineSaveRequest vaccineSaveRequest) {
        Vaccine saveVaccine = this.modelMapper.forRequest().map(vaccineSaveRequest, Vaccine.class);
        this.vaccineService.save(saveVaccine);
        VaccineResponse vaccineResponse = this.modelMapper.forResponse().map(saveVaccine, VaccineResponse.class);
        return ResultHelper.created(vaccineResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> getById(@PathVariable Long id) {
        try {
            Vaccine vaccine = vaccineService.get(id);
            VaccineResponse vaccineResponse = modelMapper.forResponse().map(vaccine, VaccineResponse.class);
            return ResultHelper.success(vaccineResponse);
        } catch (NotFoundException e) {
            return (ResultData<VaccineResponse>) ResultHelper.recordNotFoundWithId(id);
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<VaccineResponse> update(@PathVariable Long vaccineId, @Valid @RequestBody VaccineSaveRequest vaccineSaveRequest) {
        Vaccine vaccine = modelMapper.forRequest().map(vaccineSaveRequest, Vaccine.class);
        vaccine.setId((vaccineId)); // Ensure the vaccine has the correct ID
        try {
            Vaccine existingVaccine = vaccineService.get(vaccineId);
            Vaccine updatedVaccine = vaccineService.update(vaccine);
            VaccineResponse vaccineResponse = modelMapper.forResponse().map(updatedVaccine, VaccineResponse.class);
            return ResultHelper.success(vaccineResponse);
        } catch (NotFoundException e) {
            return (ResultData<VaccineResponse>) ResultHelper.recordNotFoundWithId(vaccineId);
        }
    }

    @GetMapping("/animal/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<VaccineResponse>> getByAnimalId(@PathVariable Long animalId) {
        try {
            List<Vaccine> vaccines = vaccineService.getByAnimalId(animalId);
            List<VaccineResponse> vaccineResponses = vaccines.stream()
                    .map(vaccine -> modelMapper.forResponse().map(vaccine, VaccineResponse.class))
                    .toList();
            return ResultHelper.success(vaccineResponses);
        } catch (NotFoundException e) {
            return (ResultData<List<VaccineResponse>>) ResultHelper.recordNotFoundWithId(animalId);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable Long id) {
        try {
            vaccineService.delete(id);
            return ResultHelper.ok();
        } catch (NotFoundException e) {
            return ResultHelper.recordNotFoundWithId(id);
        }
    }

    @GetMapping("/validity")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<VaccineResponse>> getVaccinesByEndDateBetween(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        try {
            List<Vaccine> vaccines = vaccineService.getVaccinesByEndDateBetween(startDate, endDate);
            List<VaccineResponse> vaccineResponses = vaccines.stream()
                    .map(vaccine -> modelMapper.forResponse().map(vaccine, VaccineResponse.class))
                    .toList();
            return ResultHelper.success(vaccineResponses);
        } catch (NotFoundException e) {
            return (ResultData<List<VaccineResponse>>) ResultHelper.recordNotFoundWithId(startDate.toEpochDay());
        }
    }
}
