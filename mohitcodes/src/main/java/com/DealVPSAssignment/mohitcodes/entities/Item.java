package com.DealVPSAssignment.mohitcodes.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "items")
@NoArgsConstructor
@Setter
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;

    @Column(name = "item_name", nullable = false, length = 50)
    @NotNull
    private String name;
    private String description;


}
