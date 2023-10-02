package io.digital101.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    @ManyToOne
    @JoinColumn(name = "chain_id")
    private Chain chain;

    private String locationName;
    private String address;
    private String district;
    private String city;
    private String country;
    private double latitude;
    private double longitude;
    private String phone;
    private String email;
    private String website;
    private String socialMedia;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;


}
