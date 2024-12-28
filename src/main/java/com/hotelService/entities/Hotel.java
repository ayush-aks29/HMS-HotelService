package com.hotelService.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}
