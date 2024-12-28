package com.hotelService.entities;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Hotel {

    private String id;
    private String name;
    private String location;
    private String about;

}
