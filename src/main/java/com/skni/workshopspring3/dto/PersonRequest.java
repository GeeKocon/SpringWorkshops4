package com.skni.workshopspring3.dto;

import com.skni.workshopspring3.repo.entity.Address;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PersonRequest {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank(message = "Lastname is mandatory")
    @Size(min = 2, max = 20)
    private String lastname;

    private LocalDate birthdate;

    private GenderEnum gender;

    @NotBlank(message = "Address is mandatory")
    @Size(min = 2, max = 30)
    private Address address;
}
