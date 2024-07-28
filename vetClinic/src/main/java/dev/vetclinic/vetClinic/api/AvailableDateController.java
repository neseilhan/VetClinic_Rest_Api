package dev.vetclinic.vetClinic.api;

import dev.vetclinic.vetClinic.business.concretes.AvailableDateManager;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.config.Result;
import dev.vetclinic.vetClinic.core.config.ResultData;
import dev.vetclinic.vetClinic.core.config.ResultHelper;
import dev.vetclinic.vetClinic.core.modelMapper.IModelMapperService;
import dev.vetclinic.vetClinic.dto.request.AvailableDateSaveRequest;
import dev.vetclinic.vetClinic.dto.request.AvailableDateUpdateRequest;
import dev.vetclinic.vetClinic.dto.response.AvailableDateResponse;
import dev.vetclinic.vetClinic.dto.response.DoctorResponse;
import dev.vetclinic.vetClinic.entities.AvailableDate;
import dev.vetclinic.vetClinic.entities.Doctor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/available_dates")
public class AvailableDateController {
    private final AvailableDateManager availableDateService;
    private final IModelMapperService modelMapper;

    public AvailableDateController(AvailableDateManager availableDateService, IModelMapperService modelMapper) {
        this.availableDateService = availableDateService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableDateResponse> save (@Valid @RequestBody AvailableDateSaveRequest availableDateSaveRequest){
        AvailableDate saveAvailableDate = this.modelMapper.forRequest().map(availableDateSaveRequest, AvailableDate.class);
        this.availableDateService.save(saveAvailableDate);
        AvailableDateResponse availableDateResponse = this.modelMapper.forResponse().map(saveAvailableDate, AvailableDateResponse.class);
        return ResultHelper.created(availableDateResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AvailableDateResponse> get(@PathVariable("id") Long id ){
        AvailableDate availableDate = this.availableDateService.get(id);
        AvailableDateResponse availableDateResponse = this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class);
        return ResultHelper.success(availableDateResponse);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AvailableDateResponse> update(@Valid @RequestBody AvailableDateUpdateRequest availableDateUpdateRequest){
        AvailableDate updateAvailableDate = this.modelMapper.forRequest().map(availableDateUpdateRequest, AvailableDate.class);
        this.availableDateService.save(updateAvailableDate);
        AvailableDateResponse availableDateResponse = this.modelMapper.forResponse().map(updateAvailableDate, AvailableDateResponse.class);
        return ResultHelper.created(availableDateResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.availableDateService.delete(id);
        return ResultHelper.success(Msg.OK);
    }
}
