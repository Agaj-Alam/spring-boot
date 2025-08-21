package com.codingShullte.Projects.airBnbApp.controller;

import com.codingShullte.Projects.airBnbApp.dto.HotelDto;
import com.codingShullte.Projects.airBnbApp.entity.Hotel;
import com.codingShullte.Projects.airBnbApp.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto>createNewHotel(@RequestBody HotelDto hotelDto){
        log.info("Attemting to craete a new hotel with name: "+hotelDto.getName());
        HotelDto hotel=hotelService.createNewHotel(hotelDto);
        return new ResponseEntity<>(hotel,HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto>getHotelById(@PathVariable Long hotelId){
        HotelDto hotelDto=hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotelDto);
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>>getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<HotelDto>updateHotelById(@PathVariable long hotelId,@RequestBody HotelDto hotelDto){
        HotelDto hotel=hotelService.updateHotelById(hotelId, hotelDto);
        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Void>deleteHotelById(@PathVariable Long hotelId){
       hotelService.deleteHotelById(hotelId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{hotelId}")
    public ResponseEntity<Void>activateHotelBYId(@PathVariable Long hotelId){
        hotelService.activateHotel(hotelId);
        return ResponseEntity.noContent().build();
    }
}
