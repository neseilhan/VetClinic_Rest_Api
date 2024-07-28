package dev.vetclinic.vetClinic.dto.response;

import dev.vetclinic.vetClinic.entities.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineResponse {

    private Long id;

    private String name;

    private String code;

    private LocalDate startDate;

    private LocalDate endDate;

//    private Animal animal;
}
