package com.hotelService.service;

import com.hotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel saveHotel(Hotel hotel);

    //get all hotels
    List<Hotel> getAllHotels();

    //get hotel by ID
    Hotel getHotel(String hotelId);

    //delete hotel
    Hotel deleteHotel(String hotelId);

    //update hotel
    Hotel updateHotel(String hotelId, Hotel hotel);
}
