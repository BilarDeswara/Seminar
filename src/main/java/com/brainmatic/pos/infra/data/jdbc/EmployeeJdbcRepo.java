package com.brainmatic.pos.infra.data.jdbc;

import com.brainmatic.pos.core.entity.Employee;
import com.brainmatic.pos.core.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeJdbcRepo {

    private JdbcTemplate jdbc;

    public EmployeeJdbcRepo(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    private final String GET_ALL = "select id,name from employee";
    private final String GET_BY_ID = "SELECT id,name from employee where id=?";

    private Employee map(ResultSet rs) throws SQLException {
        Employee p = new Employee();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        return p;
    }


    public List<Employee> getAll(){
        return jdbc.query(GET_ALL,(rs, rowNum) ->
                map(rs));
    }

    public Employee getById(int id) {
        return jdbc.query(GET_BY_ID, new Object[]{id}, rs -> {
            rs.next();
            Employee p = new Employee();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            return p;
        });
    }
}
