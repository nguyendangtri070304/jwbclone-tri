package com.group11.moviebooking.convert;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MappingDTOtoJSON {

    public static String convertToJson(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
