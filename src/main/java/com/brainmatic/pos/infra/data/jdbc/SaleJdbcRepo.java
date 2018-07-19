package com.brainmatic.pos.infra.data.jdbc;

import com.brainmatic.pos.core.entity.Employee;
import com.brainmatic.pos.core.entity.Product;
import com.brainmatic.pos.core.entity.Sale;
import com.brainmatic.pos.core.entity.repo.entityrepo.SaleRepo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class SaleJdbcRepo implements SaleRepo {

    private JdbcTemplate jdbc;

    public SaleJdbcRepo(JdbcTemplate jdbc){

        this.jdbc=jdbc;
    }

    private final String DELETE_BY_ID = "delete from sale where id=?";
    private final String GET_ID = "SELECT id,employeeid from sale where id=?";

    @Override
    public int getCount(){
        return 0;
    }

    @Override
    public List<Sale> getAll(){
        return null;
    }

    @Override
    public void save(Sale sale){
        String sqlSale="INSERT INTO SALE VALUES (?,?)";
        jdbc.update(sqlSale, sale.getId(),sale.getCasher().getId());

       String sqlSli="INSERT INTO SALELINEITEM VALUES(?,?,?,?)";
       List<Object[]> paramList = sale.getLineItems()
               .stream()
               .map(sli -> new Object[] {sale.getId(),sli.getProduct().getId(), sli.getQuantity(), sli.getUnitPrice()})
               .collect(Collectors.toList());

//       List paramList = new ArrayList<Object>();
//        for (SaleLineItem sli : sale.getLineItems()){
//            Object[] params = new Object[] {sale.getId(),sli.getProduct().getId(), sli.getQuantity(), sli.getUnitPrice()};
//            paramList.add(params);
////            jdbc.update(sqlSli, sli.getQuantity(),sli.getUnitPrice(),sale.getId(),sli.getProduct().getId());
//        }
        jdbc.batchUpdate(sqlSli,paramList);
    }

    @Override
    public int remove(int id) {
            return jdbc.update(DELETE_BY_ID,id);
    }

//    public Sale getId(int id){
//        return jdbc.query(GET_ID, new Object[]{id}, rs -> {
//            rs.next();
//            Sale p = new Sale();
//            p.setId(rs.getInt("id"));
//            p.se
//            return p;
//        });
//    }

    public Sale getByIdEager(int id){
        String sql = "SELECT * FROM SALE s JOIN SALELINEITEM sli on s.id=sli.saleid JOIN PRODUCT p on sli.saleid=p.id where s.id=?";
        return jdbc.query(sql,new Object[]{id}, rs -> {
            Sale sale = new Sale();
            sale.setId(id);
            Employee e = new Employee();
            rs.next();
            e.setId(rs.getInt("employeeid"));
            sale.setCasher(e);
            do{
                Product p = new Product();
                p.setId(rs.getInt("productid"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getBigDecimal("price"));
                sale.addlineItems(p, rs.getInt("quantity"));
            }while (rs.next());
            return sale;
        });
    }


    public Sale getById(int id){
        String sql = "SELECT * FROM SALE s JOIN SALELINEITEM sli on s.id=sli.saleid where s.id=?";
        return jdbc.query(sql,new Object[]{id}, rs -> {
            Sale sale = new Sale();
            sale.setId(id);
            Employee e = new Employee();
            rs.next();
            e.setId(rs.getInt("employeeid"));
            sale.setCasher(e);
            do{
                Product p = new Product();
                p.setId(rs.getInt("productid"));
                sale.addlineItems(p, rs.getInt("quantity"));
            }while (rs.next());
            return sale;
        });
    }



}
