package com.HospitalManagementSys.Controller;

import com.HospitalManagementSys.Payload.RoomDto;
import com.HospitalManagementSys.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hospitalManagementSystem/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    //http://localhost:9090/api/hospitalManagementSystem/room/create
    @PostMapping("/create")
    public ResponseEntity<String> createroomDetails(@RequestBody RoomDto roomDto){
        roomService.registerRoom(roomDto);
        return new ResponseEntity<>("room details created", HttpStatus.CREATED);
    }
}
