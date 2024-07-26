package dev.vetclinic.vetClinic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {


    @NotNull(message = "Date field can not be null.")
    private LocalDate availableDate;

    @NotNull(message = "Doctor field can not be null.")
    private Long doctorId;
}
