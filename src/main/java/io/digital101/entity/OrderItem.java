package io.digital101.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

    public Orders getCustomerOrder() {
        return orders;
    }

    public void setCustomerOrder(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
