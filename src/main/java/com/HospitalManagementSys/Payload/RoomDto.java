package com.HospitalManagementSys.Payload;


import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class RoomDto {

    private long roomId;

    private int roomNo;

    private String roomType;

    private String status;

}
