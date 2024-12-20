package com.group11.moviebooking.repository;

import com.group11.moviebooking.entity.RoomEntity;
import com.group11.moviebooking.model.RoomDTO;
import com.group11.moviebooking.util.ConnectionPool;
import com.group11.moviebooking.util.ConnectionPoolImpl;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepositoryImpl implements RoomRepository {
    private final ConnectionPool connectionPool;

    public RoomRepositoryImpl() {
        this.connectionPool = ConnectionPoolImpl.getInstance();
    }

    @Override
    public int getAvailableSeats(int room_id) {
        return 0;
    }

    @Override
    public boolean updateRoom(int room_id, int new_capacity) {
        return false;
    }

    @Override
    public boolean createRoom(String room_name, int room_capacity, int hall_id) {
        return false;
    }

    @Override
    public boolean deleteRoom(int room_id) {
        return false;
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        List<RoomDTO> roomDTOs = new ArrayList<>();
        String sql = "SELECT * FROM tblrooms";
        try (Connection connection = connectionPool.getConnection("RoomRepositoryImpl.getAllRooms");
             PreparedStatement pre = connection.prepareStatement(sql)) {
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    RoomDTO roomDTO = new RoomDTO();
                    roomDTO.setRoom_id(rs.getInt("room_id"));
                    roomDTO.setRoom_name(rs.getString("room_name"));
                    roomDTO.setRoom_capacity(rs.getShort("room_capacity"));
                    roomDTO.setRoom_location(rs.getString("room_location"));
                    roomDTO.setRoom_screen_type(rs.getString("room_screen_type"));
                    roomDTO.setRoom_sound_system(rs.getString("room_sound_system"));
                    roomDTO.setRoom_created_at(rs.getString("room_created_at"));
                    roomDTOs.add(roomDTO);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomDTOs;
    }

    @Override
    public RoomEntity getRoomById(int room_id) {
        return null;
    }

    @Override
    public List<RoomEntity> getRoomEntities() {
        return List.of();
    }
}
