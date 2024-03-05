package com.nhattruongnguyen.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "logs")
public class LogEntity extends BaseEntity {
    @Column
    private String event;
    @Column
    private String type;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
