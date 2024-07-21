package dev.vetclinic.vetClinic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponse {
    private long id;
    private String name;

    private String species;

    private String breed;

    private String gender;

    private String color;

    private LocalDate birthDate;

    private String customerName;

    private String customerPhone;
}