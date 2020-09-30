package com.example.shoppet.dao.user;

import com.example.shoppet.entity.MapperSlides;
import com.example.shoppet.entity.Slides;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SlidesDao  {
    @Autowired
    public JdbcTemplate _jdbcTemplate;

    public List<Slides> GetDataSlide(){
        List<Slides> list = new ArrayList<Slides>();
        String sql = "SELECT * FROM slides";
        list = _jdbcTemplate.query(sql, new MapperSlides());
        return list;
    }
}
