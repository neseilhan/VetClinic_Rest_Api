package dev.vetclinic.vetClinic.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

//    private Long id; //save request icin id kullanma.
//
    @NotNull(message = "Customer name can not be null.")
    private String name;

    private String phone;

    @Email
    private String mail;

    private String address;

    private String city;
}
