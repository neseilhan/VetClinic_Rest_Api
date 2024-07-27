package dev.vetclinic.vetClinic.api;

import dev.vetclinic.vetClinic.business.concretes.AppointmentManager;
import dev.vetclinic.vetClinic.core.config.Msg;
import dev.vetclinic.vetClinic.core.config.Result;
import dev.vetclinic.vetClinic.core.config.ResultData;
import dev.vetclinic.vetClinic.core.config.ResultHelper;
import dev.vetclinic.vetClinic.core.modelMapper.IModelMapperService;
import dev.vetclinic.vetClinic.dto.request.AppointmentSaveRequest;
import dev.vetclinic.vetClinic.dto.request.AppointmentUpdateRequest;
import dev.vetclinic.vetClinic.dto.response.AppointmentResponse;
import dev.vetclinic.vetClinic.entities.Appointment;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {
    private final AppointmentManager appointmentService;
    private final IModelMapperService modelMapper;

    public AppointmentController(AppointmentManager appointmentService, IModelMapperService modelMapper) {
        this.appointmentService = appointmentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AppointmentResponse> save (@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest){
        Appointment saveAppointment = this.modelMapper.forRequest().map(appointmentSaveRequest, Appointment.class);
        this.appointmentService.save(saveAppointment);
        AppointmentResponse appointmentResponse = this.modelMapper.forResponse().map(saveAppointment, AppointmentResponse.class);
        return ResultHelper.created(appointmentResponse);
    }

    @GetMapping("/filterDate")
    public List<Appointment> filterAppointments(
        @RequestParam LocalDate startDate,
        @RequestParam LocalDate endDate,
        @RequestParam String animalName) {
    return appointmentService.findByAnimalAndDateBetween(startDate, endDate, animalName);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AppointmentResponse> update(@Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest){
        Appointment updateAppointment = this.modelMapper.forRequest().map(appointmentUpdateRequest, Appointment.class);
        this.appointmentService.save(updateAppointment);
        AppointmentResponse appointmentResponse = this.modelMapper.forResponse().map(updateAppointment, AppointmentResponse.class);
        return ResultHelper.created(appointmentResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") long id){
        this.appointmentService.delete(id);
        return ResultHelper.success(Msg.OK);
    }
}
