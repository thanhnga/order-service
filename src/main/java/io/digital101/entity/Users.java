package io.digital101.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column( unique = true)
    private String username;

    private String password;

    private String name;
    @Column(unique = true)
    private String email;

    private String phoneNumber;

    private String address;

    @Enumerated(EnumType.STRING)
    private UserRole role;


    @Enumerated(EnumType.STRING)
    private UserStatus status;


}
