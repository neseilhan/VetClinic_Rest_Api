package dev.vetclinic.vetClinic.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Long id;

    private String name;

    private String phone;

    private String mail;

    private String address;

    private String city;

    private List<AnimalResponse> animalList;
}
