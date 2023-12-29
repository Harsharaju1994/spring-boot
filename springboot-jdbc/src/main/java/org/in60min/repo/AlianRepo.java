package org.in60min.repo;

import org.in60min.entity.Alian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlianRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alian alian1){
        String sql = "insert into alian (id,name,tech) values(?,?,?)";
        int rows = template.update(sql,alian1.getId(),alian1.getName(),alian1.getTech());
        System.out.println(rows + " row/s affected");
    }

    public List<Alian> findAll(){

        String sql = "select * from alian";

        RowMapper<Alian> mapper = new RowMapper<Alian>() {
            @Override
            public Alian mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alian alian2 = new Alian();
                alian2.setId(rs.getInt(1));
                alian2.setName(rs.getString(2));
                alian2.setTech(rs.getString(3));
                return alian2;
            }
        };

        List<Alian> alians = template.query(sql,mapper);

        return alians;
    }




















}
