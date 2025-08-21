package com.codingShullte.Projects.airBnbApp.service;

import com.codingShullte.Projects.airBnbApp.dto.HotelDto;

import java.util.List;
import java.util.Set;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);
    HotelDto getHotelById(Long id);
    List<HotelDto> getAllHotels();
    HotelDto updateHotelById(Long id, HotelDto hotelDto);
    void deleteHotelById(Long id);
    void activateHotel(Long hotelId);
}
