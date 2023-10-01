package io.digital101.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemCategory  {
    @Id
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    public Item getMenuItem() {
        return item;
    }

    public void setMenuItem(Item item) {
        this.item = item;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
