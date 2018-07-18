package com.brainmatic.pos;

import com.brainmatic.pos.core.Product;
import com.brainmatic.pos.core.SaleLineItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class SaleLineItemTest {
    @Test
    public void aaasss(){
        Product pl = new Product();
        pl.setPrice(BigDecimal.valueOf(500));

        //SaleLineItem sli = new SaleLineItem();
        SaleLineItem sli = new SaleLineItem(pl,2);
        //sli.setQuantity(2);
        //sli.setProduct(pl);
        //sli.setUnitPrice(pl.getPrice());
        BigDecimal subTotal = sli.getSubTotal();

        assertEquals(BigDecimal.valueOf(1000), subTotal);

    }
}
