package io.digital101.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrderItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;


}
