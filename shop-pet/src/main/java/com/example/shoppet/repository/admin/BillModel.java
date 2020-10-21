package com.example.shoppet.repository.admin;

import com.example.shoppet.dto.BillsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BillModel extends PagingAndSortingRepository<BillsDto, Long> {
    Page<BillsDto> findBillsDtoBy(int start, Pageable pageable);
    Page<BillsDto> findByName(String name, Pageable pageable);
}
