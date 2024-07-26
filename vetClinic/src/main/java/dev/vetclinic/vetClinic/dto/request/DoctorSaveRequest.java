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
public class DoctorSaveRequest {

    @NotNull(message = "Doctor name can not be null.")
    @NotEmpty
    private String name;

    private String phone;

    @Email
    private String mail;

    private String address;

    private String city;
}
