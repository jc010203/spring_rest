package com.frankmoley.reservations.landon.business.service;

import com.frankmoley.reservations.landon.business.domain.RoomReservation;
import com.frankmoley.reservations.landon.data.entity.Guest;
import com.frankmoley.reservations.landon.data.entity.Reservation;
import com.frankmoley.reservations.landon.data.entity.Room;
import com.frankmoley.reservations.landon.data.repository.GuestRepository;
import com.frankmoley.reservations.landon.data.repository.ReservationRepository;
import com.frankmoley.reservations.landon.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by juan.hernandez on 6/22/17.
 */



@Service
public class ReservationService {

    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date){
        // get all rooms
        Iterable<Room> rooms = this.roomRepository.findAll();

        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();

        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });

        Iterable<Reservation> reservations  = this.reservationRepository.findByDate(new java.sql.Date(date.getTime()));
        if(null != reservations){
            reservations.forEach(reservation -> {
                Guest guest = this.guestRepository.findOne(reservation.getGuestId());
                if(null != guest){
                    RoomReservation roomReservation = roomReservationMap.get(reservation.getReservationId());
                    roomReservation.setDate(date);
                    roomReservation.setFirstName(guest.getFirstName());
                    roomReservation.setLastName(guest.getLastName());
                    roomReservation.setGuestId(guest.getId());
                }
            });
        }

        List<RoomReservation> roomReservations = new ArrayList<>();

        for(Long roomId : roomReservationMap.keySet()){
            roomReservations.add(roomReservationMap.get(roomId));
        }

        return roomReservations;
    }
}
