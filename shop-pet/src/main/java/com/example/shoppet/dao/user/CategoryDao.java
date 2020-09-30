package com.example.shoppet.dao.user;

import com.example.shoppet.entity.MapperSlides;
import com.example.shoppet.entity.Slides;
import com.example.shoppet.entity.user.Categorys;
import com.example.shoppet.entity.user.MapperCategorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDao extends BaseDao{

    public List<Categorys> GetDataCategorys(){
        List<Categorys> list = new ArrayList<Categorys>();
        String sql = "SELECT * FROM category";
        list = _jdbcTemplate.query(sql, new MapperCategorys());
        return list;
    }
}
