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
}
