package com.brainmatic.pos.infra.data.jdbc;

import com.brainmatic.pos.core.entity.Product;
import com.brainmatic.pos.core.entity.repo.entityrepo.ProductRepo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductJdbcRepo implements ProductRepo {

    private JdbcTemplate jdbc;

    public ProductJdbcRepo(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    private final String COUNT = "select count(*) From Product";
    private final String GET_BY_ID = "SELECT id,code,name,price from product where id=?";
    private final String DELETE_BY_ID = "delete from product where id=?";
    private final String SAVE = "insert into product (id,code,name,price) values(?,?,?,?)";
    private final String GET_ALL = "select id,code,name,price from product";

    @Override
    public int getCount() {

        return jdbc.query(COUNT,rs -> {
            rs.next();
            return rs.getInt(1);
        });
    }
//
    @Override
    public Product getById(int id) {
        return jdbc.query(GET_BY_ID, new Object[]{id}, rs -> {
            rs.next();
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setCode(rs.getString("code"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getBigDecimal("price"));
            return p;
        });
    }

    @Override
    public int remove(int id) {
        return jdbc.update(DELETE_BY_ID,id);
    }

    @Override
    public void save(Product product) {
        jdbc.update(SAVE, new Object[]{product.getId(),product.getCode(),product.getName(),product.getPrice()});
    }

    private Product map(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setCode(rs.getString("code"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getBigDecimal("price"));
        return p;
    }

    @Override
    public List<Product> getAll(){
        return jdbc.query(GET_ALL,(rs, rowNum) -> map(rs));
    }
}
