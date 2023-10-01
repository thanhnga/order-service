package io.digital101.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MenuItem  {
    @Id
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Id
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    public Item getMenuItem() {
        return item;
    }

    public void setMenuItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
