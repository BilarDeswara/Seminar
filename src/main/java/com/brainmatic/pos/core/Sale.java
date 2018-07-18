package com.brainmatic.pos.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Sale {
    private int id;
    private LocalDateTime time;
    private Employee casher;
    //private ArrayList<Product> prd;
    private ArrayList<SaleLineItem> lineItems;

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

   // public ArrayList<Product> getPrd() {
   //     return prd;
   // }

   // public void setPrd(ArrayList<Product> prd) {
   //    this.prd = prd;
   // }

    public ArrayList<SaleLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(ArrayList<SaleLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Sale() {
        this.time = LocalDateTime.now();
        lineItems = new ArrayList<>();
    }

    public void addlineItems(Product product, int quantity) {
        SaleLineItem sli = new SaleLineItem(product,quantity);
        lineItems.add(sli);
       // prd.add(product);
    }

    public BigDecimal getTotal() {
//        lineItems.stream().
//                map(SaleLineItem::getSubTotal).
//                reduce(BigDecimal.ZERO,(a,b)-> a.add(b))
        BigDecimal total = BigDecimal.ZERO;
        for (SaleLineItem sli: lineItems) {
            total = total.add(sli.getSubTotal());
        }
        return total;
    }
}
