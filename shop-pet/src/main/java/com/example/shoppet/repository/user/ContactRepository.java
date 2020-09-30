package com.example.shoppet.repository.user;

import com.example.shoppet.entity.user.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}