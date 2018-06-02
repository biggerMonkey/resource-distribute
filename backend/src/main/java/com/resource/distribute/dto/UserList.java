package com.resource.distribute.dto;

import com.resource.distribute.entity.User;

public class UserList extends User {

    private String depName;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
