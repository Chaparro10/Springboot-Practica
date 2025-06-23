package com.platzi.platzi_pizzeria.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "UserRole")
public class UserRoleEntity {

    @Id
    @Column(nullable = false,length = 20)
    private String username;

    private Long role;

    @Column(name = "granted_date",nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime grantedDate;

    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "username",insertable = false,updatable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "role",referencedColumnName = "id",insertable = false,updatable = false)
    private RolesEntity roles;
}
