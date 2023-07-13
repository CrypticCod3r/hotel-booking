package com.nathanbianco.hotelbookingbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "floor")
    private int floor;

    @Column(name = "number")
    private String number;

    @Column(name = "beds")
    private int beds;

    @Column(name = "rate")
    private double rate;

}
