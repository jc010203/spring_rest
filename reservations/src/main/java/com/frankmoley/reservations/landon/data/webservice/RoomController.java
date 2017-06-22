package com.frankmoley.reservations.landon.data.webservice;

import com.frankmoley.reservations.landon.data.entity.Room;
import com.frankmoley.reservations.landon.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juan.hernandez on 6/21/17.
 */

@RestController
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value="/rooms", method = RequestMethod.GET)
    public List<Room> findAll(@RequestParam(required = false) String roomNumber){
        List<Room> rooms = new ArrayList<>();
        if(roomNumber == null){
           Iterable<Room> results = this.roomRepository.findAll();
           results.forEach( room -> { rooms.add(room); } );
        } else {
            Room room = this.roomRepository.findByNumber(roomNumber);
            if(room != null ){
                rooms.add(room);
            }
        }

        return rooms;
    }
}
