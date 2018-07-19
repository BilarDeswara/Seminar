package com.brainmatic.pos.core.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sale {
    @Id
    private int id;
    private LocalDateTime time;
    @ManyToOne
    private Employee casher;
    @ElementCollection
    private List<SaleLineItem> lineItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Employee getCasher() {
        return casher;
    }

    public void setCasher(Employee casher) {
        this.casher = casher;
    }

    public List<SaleLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<SaleLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Sale() {
        this.time = LocalDateTime.now();
        lineItems = new ArrayList<>();
    }

    public void addlineItems(Product product, int quantity) {
        SaleLineItem sli = new SaleLineItem(product,quantity);
        lineItems.add(sli);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (SaleLineItem sli: lineItems) {
            total = total.add(sli.getSubTotal());
        }
        return total;
    }
}
