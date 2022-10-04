package com.prumoitstore.order.dto;

import lombok.Data;

@Data
public class ClientRequest {
    private Integer id;
    private String surname;
    private String lastname;
    private String email;
    private String phone;
    private String nif;
    private Integer address;
}
