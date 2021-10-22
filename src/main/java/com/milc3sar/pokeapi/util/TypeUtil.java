package com.milc3sar.pokeapi.util;


import com.milc3sar.pokeapi.domain.Type;

import java.util.Map;

public class TypeUtil {

    public static Type mapToUtil(Map<String, Object> data) {
        Type type = new Type();
        type.setName(data.get("name").toString());
        return type;
    }
}
