package com.assetbookingapp.admin.model;

import java.util.HashMap;
import java.util.Map;

public enum UserType {
    ADMIN,
    USER;

    private static final Map<String, UserType> USER_TYPE_MAP = new HashMap<>();

    static {
        for (UserType userType : UserType.values()) {
            USER_TYPE_MAP.put(userType.toString(), userType);
        }
    }

    public static UserType getByValue(String type) {
        return USER_TYPE_MAP.get(type);
    }

}
