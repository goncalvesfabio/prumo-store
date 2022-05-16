package com.prumoitstore.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;
    private String streetName;
    private String streetNumber;
    private String city;
    private String zipCode;
    private String country;
    private String estate;
    @OneToOne(mappedBy = "address")
    private Client client;
}
