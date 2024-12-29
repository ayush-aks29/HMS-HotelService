package com.hotelService.controller;

import com.hotelService.entities.Hotel;
import com.hotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    //create
    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel savedHotel = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }

    //get all hotels
    @GetMapping("/getHotel")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> allHotels = hotelService.getAllHotels();
        return ResponseEntity.ok(allHotels);
    }

    //get single hotel
    @GetMapping("/getHotel/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        Hotel hotel = hotelService.getHotel(hotelId);
        //return ResponseEntity.status(HttpStatus.OK).body(hotel);
        return ResponseEntity.ok(hotel);
    }

    @PutMapping("/update/{hotelId}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable String hotelId, @RequestBody Hotel hotel) {
        Hotel updatedHotel = hotelService.updateHotel(hotelId, hotel);
        return ResponseEntity.ok(updatedHotel);
    }

    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable String hotelId) {
        Hotel deletedHotel = hotelService.deleteHotel(hotelId);
        return ResponseEntity.ok(deletedHotel);
    }
    
}
