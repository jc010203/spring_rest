package com.frankmoley.reservations.landon.data.entity;

/**
 * Created by juan.hernandez on 6/21/17.
 */

import javax.persistence.*;

@Entity
@Table(name="ROOM")
public class Room {

    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;// maps to BIGINT

    @Column(name="NAME")
    private String name;

    @Column(name="ROOM_number")
    private String number;

    @Column(name="BED_INFO")
    private String bedInfo;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }
}
