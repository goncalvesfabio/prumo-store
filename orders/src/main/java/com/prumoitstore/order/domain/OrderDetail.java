package com.prumoitstore.order.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date createdAt;
    private  Date updateAt;
    private Date deletedAt;
    private Double orderTotal;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Client client;
    private  Item item;

}
