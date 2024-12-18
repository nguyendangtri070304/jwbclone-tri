package com.group11.moviebooking.convert;

import com.group11.moviebooking.entity.SeatEntity;
import com.group11.moviebooking.model.SeatDTO;

public class SeatMapper {
    public static SeatDTO mapENtityToDTO(SeatEntity seatEntity) {
        SeatDTO seatDTO = new SeatDTO();

        seatDTO.setSeat_id(seatEntity.getSeat_id());
        seatDTO.setRoom_id(seatEntity.getRoom_id());
        seatDTO.setSeat_row(seatEntity.getSeat_row());
        seatDTO.setSeat_column(seatEntity.getSeat_column());

        return seatDTO;
    }
}
