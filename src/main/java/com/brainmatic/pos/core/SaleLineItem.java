package com.brainmatic.pos.core;

import java.math.BigDecimal;

public class SaleLineItem {
    private int quantity;
    private Product product;
    private BigDecimal unitPrice;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;

    }

    public void setProduct(Product product) {
        this.product = product;
        this.unitPrice = product.getPrice(); //unitPrice langsung diisikan Nilai dari product.getPrice()
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }


    public BigDecimal getSubTotal() {
    //    BigDecimal total = BigDecimal.ZERO;
    //    total = unitPrice.add(product.getPrice());
    //    return total;
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public SaleLineItem(Product product, int quantity){
        setProduct(product);
        setQuantity(quantity);
        setUnitPrice(product.getPrice());
    }
}

    class SaleLineItemIim {

    }
