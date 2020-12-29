package com.example.jpa.Room;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RoomController {

    RoomService roomService = new RoomService();

    @RequestMapping(value = "/findallroom")
    public ModelAndView findallroom(){
        ModelAndView mv = new ModelAndView("formroom");
        return mv;
    }

}
