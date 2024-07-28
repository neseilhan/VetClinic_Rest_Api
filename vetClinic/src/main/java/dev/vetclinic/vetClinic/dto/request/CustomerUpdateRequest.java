package dev.vetclinic.vetClinic.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {

    @Positive(message = "Id must be a positive number.")
    @NotNull
    private Long id;

    @NotNull(message = "Customer name cannot be null.")
    @NotEmpty
    private String name;

    private String phone;

    @Email
    private String mail;

    private String address;

    private String city;
}
