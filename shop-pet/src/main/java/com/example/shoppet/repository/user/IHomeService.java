package com.example.shoppet.repository.user;

import com.example.shoppet.entity.Slides;
import com.example.shoppet.entity.user.Categorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IHomeService {
    @Autowired
    public List<Slides> GetDataSlide();
    public List<Categorys> GetDatacategorys();
}
