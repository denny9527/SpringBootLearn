package com.denny.task01.common.domain;

import java.util.Date;

public class User {

    private Long id;

    private String name;

    private String password;

    private String enabled;

    private Date regTime;
    
    public User(Long id, String name, String password, String enabled, Date regTime) {
    	this.id = id;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
        this.regTime = regTime;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
}