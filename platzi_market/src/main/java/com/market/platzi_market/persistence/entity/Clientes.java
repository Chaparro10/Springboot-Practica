package com.market.platzi_market.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity()
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Table(name = "clientes")
public class Clientes {



        @Id()
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String name ;
        private String firtlastname;
        private String cellphone;
        private  String adress;
        private String email;

        @OneToMany(mappedBy = "clientes")
        private List<Compra> compras;


}
