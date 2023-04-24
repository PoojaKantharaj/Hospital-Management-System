package com.HospitalManagementSys.Repository;

import com.HospitalManagementSys.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findByRoomNo(int roomNo);
}
