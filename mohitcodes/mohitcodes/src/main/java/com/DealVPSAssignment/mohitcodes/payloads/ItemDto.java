package com.DealVPSAssignment.mohitcodes.payloads;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@Setter
@Getter
@Validated
public class ItemDto {


    @Valid

    private int id;
    @NotNull
    @NotEmpty(message = "must not be empty")
    @Size(min = 4,max = 50,message = "Item name must be min 2 and maximum 50 character")
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 5,max = 200,message = "Item description must be min 5 character and maximum 200 character")
    private String description;

}
