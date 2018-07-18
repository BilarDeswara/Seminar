package com.brainmatic.pos;

import com.brainmatic.pos.core.Product;
import com.brainmatic.pos.core.Sale;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;

public class SaleTest {

    @Test
    public void new_sale_should_be_totaled_zero(){
        Sale sale = new Sale();
        BigDecimal total = sale.getTotal();

        assertEquals(total, BigDecimal.ZERO);
    }

    @Test
    public void sale_2_momogi_and_1_pepsi_should_60000(){
        // momogi 2 dan pepsi 1 total harus 60_000
        Product pl = new Product();
        pl.setPrice(BigDecimal.valueOf(500));
        Product p2 = new Product();
        p2.setPrice(BigDecimal.valueOf(5000));

        Sale sal = new Sale();
        //sal.addProducts(pl);
        //sal.addProducts(pl);
        //sal.addProducts(p2);
        sal.addlineItems(pl,2);
        sal.addlineItems(p2,1);

        assertEquals(BigDecimal.valueOf(6000), sal.getTotal());
    }

    @Test
    public void bbbba(){
        Product pl = new Product();
        pl.setPrice(BigDecimal.valueOf(500));

        Sale sal = new Sale();
        //sal.addProducts(pl);
        sal.addlineItems(pl,1);

        assertEquals(BigDecimal.valueOf(500), sal.getTotal());

        pl.setPrice(600l);
        assertEquals(BigDecimal.valueOf(500), sal.getTotal());
    }
}
