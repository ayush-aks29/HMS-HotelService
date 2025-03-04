package com.hotelService.entities;

import lombok.*;

import javax.persistence.Column;
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
    @Column(name="ID")
    private String hotelId;
    private String name;
    private String location;
    private String about;

}
