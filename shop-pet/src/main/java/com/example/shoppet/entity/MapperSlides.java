package com.example.shoppet.entity;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperSlides implements RowMapper<Slides> {
    @Override
    public Slides mapRow(ResultSet rs, int i) throws SQLException {
        Slides slides = new Slides();
        slides.setId(rs.getInt("id"));
        slides.setImg(rs.getString("img"));
        slides.setCaption(rs.getString("caption"));
        slides.setContent(rs.getString("content"));
        return slides;
    }
}
