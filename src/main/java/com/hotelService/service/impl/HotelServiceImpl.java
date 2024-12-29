package com.hotelService.service.impl;

import com.hotelService.entities.Hotel;
import com.hotelService.exceptions.ResourceNotFoundException;
import com.hotelService.repositories.HotelRepository;
import com.hotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setHotelId(randomHotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(
                ()-> new ResourceNotFoundException("Hotel not found with Id: "+hotelId+" !!")
        );
    }

    @Override
    public Hotel deleteHotel(String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(
                ()-> new ResourceNotFoundException("Hotel not found with Id: "+hotelId+" !!")
        );
        hotelRepository.delete(hotel);
        return hotel;
    }

    @Override
    public Hotel updateHotel(String hotelId, Hotel hotel) {
        Hotel existingHotel = hotelRepository.findById(hotelId).orElseThrow(
                ()-> new ResourceNotFoundException("Hotel not found with Id: "+hotelId+" !!")
        );
        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        return hotelRepository.save(existingHotel);
    }
}
