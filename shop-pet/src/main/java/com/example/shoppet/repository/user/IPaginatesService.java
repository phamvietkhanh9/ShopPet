package com.example.shoppet.repository.user;

import com.example.shoppet.dto.PaginatesDto;
import org.springframework.stereotype.Service;

@Service
public interface IPaginatesService {
    public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage);
  //public PaginatesDto GetInfoPaginates(Integer totalData, Integer limit, Integer currentPage);
}
