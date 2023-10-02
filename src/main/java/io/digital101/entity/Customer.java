package io.digital101.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String phoneNumber;
    private String homeAddress;
    private String workAddress;
    @Column(unique = true)
    private String email;
    private int totalOrder=0;


}
