package com.frankmoley.reservations.landon.data.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by juan.hernandez on 6/22/17.
 */

@Entity
@Table(name="RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RESERVATION_ID")
    private long reservationId;
    @Column(name="ROOM_ID")
    private long roomId;
    @Column(name="GUEST_ID")
    private long guestId;
    @Column(name="RES_DATE")
    private Date date;

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
