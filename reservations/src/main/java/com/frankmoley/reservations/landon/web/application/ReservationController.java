package com.frankmoley.reservations.landon.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by juan.hernandez on 6/28/17.
 */

@Controller
@RequestMapping(value="/reservations")
public class ReservationController {

    @RequestMapping(method = RequestMethod.GET)
    public String getReservaitons(){
        return "reservations";
    }
}
