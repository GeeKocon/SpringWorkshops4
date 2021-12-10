package com.skni.workshopspring3.dto;

import com.skni.workshopspring3.repo.entity.Address;
import com.skni.workshopspring3.repo.entity.GenderEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonResponse {
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private GenderEnum gender;
    private Address address;
}