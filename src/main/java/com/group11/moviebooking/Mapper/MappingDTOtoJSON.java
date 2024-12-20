package com.group11.moviebooking.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class MappingDTOtoJSON {

    public ObjectMapper mapper(List<Object> list){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String chartJson = mapper.writeValueAsString(list); // Chuyển đổi thành JSON
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapper;
    }
}
