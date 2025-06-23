package com.platzi.platzi_pizzeria.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Roles")
public class RolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false,columnDefinition = "TINYINT")
    private Boolean status;

    @OneToMany(mappedBy = "roles")
    private List<UserRoleEntity> rolesEntityList;
}
