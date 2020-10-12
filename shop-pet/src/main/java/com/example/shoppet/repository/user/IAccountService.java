package com.example.shoppet.repository.user;

import com.example.shoppet.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService {
    public int addAccount(Users users);
    public boolean CheckAccount(Users user);
}
