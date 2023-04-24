package com.HospitalManagementSys.Service;

import com.HospitalManagementSys.Entities.Room;
import com.HospitalManagementSys.Payload.RoomDto;
import com.HospitalManagementSys.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements  RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void registerRoom(RoomDto roomDto) {
        Room room = mapToEntity(roomDto);
        roomRepository.save(room);
    }

    public Room mapToEntity(RoomDto roomDto){
        Room room = new Room();
        room.setRoomNo(roomDto.getRoomNo());
        room.setRoomType(roomDto.getRoomType());
        room.setStatus(roomDto.getStatus());
        return room;
    }
}
