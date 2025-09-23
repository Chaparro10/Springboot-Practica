package com.Splitwise.Splitwise.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Membership {
    @Id
    @Column(nullable = false,length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 20)
    private Long userId;

    @Column(nullable = false,length = 20)
    private Long roleId;

    @Column(nullable = false,length = 20)
    private String nickname;
}
