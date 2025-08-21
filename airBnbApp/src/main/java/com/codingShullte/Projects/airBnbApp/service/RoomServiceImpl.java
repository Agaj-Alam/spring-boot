package com.codingShullte.Projects.airBnbApp.service;

import com.codingShullte.Projects.airBnbApp.dto.RoomDto;
import com.codingShullte.Projects.airBnbApp.entity.Hotel;
import com.codingShullte.Projects.airBnbApp.entity.Room;
import com.codingShullte.Projects.airBnbApp.exception.ResourceNotFoundException;
import com.codingShullte.Projects.airBnbApp.repository.HotelRepository;
import com.codingShullte.Projects.airBnbApp.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService{
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;

    @Override
    public RoomDto createNewRoom(Long hotelId,RoomDto roomDto) {
     log.info("creating new room with id {}",hotelId);
     Hotel hotel=hotelRepository.findById(hotelId)
             .orElseThrow(()->new ResourceNotFoundException("hotel not found with id: "+hotelId));
     Room room=modelMapper.map(roomDto,Room.class);
     room.setHotel(hotel);
     Room savedRoom=roomRepository.save(room);

     // this is for to create inventory
     if(hotel.getActive()){
         inventoryService.initializeRoomForAYear(room);
     }



        return modelMapper.map(savedRoom,RoomDto.class);
    }

    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        log.info("getting allRooms in hotel with id {}",hotelId);
        Hotel hotel=hotelRepository.findById(hotelId)
                .orElseThrow(()->new ResourceNotFoundException("hotel not found with id: "+hotelId));

        return hotel.getRooms()
                .stream()
                .map((element) -> modelMapper.map(element, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        log.info("getting room with id: {}",roomId);
        Room room=roomRepository.findById(roomId)
                .orElseThrow(()->new ResourceNotFoundException("room not found with id: "+roomId));

        return modelMapper.map(room,RoomDto.class);
    }

    @Override
    public void deleteRoomById(Long roomId) {
        log.info("deleting room  with id: {}",roomId);
        boolean exists=roomRepository.existsById(roomId);
        if(!exists){
            throw new ResourceNotFoundException("room not found with id: "+roomId);
        }
        roomRepository.deleteById(roomId);

       //TODO delete all future inventory for this room
    }
}
