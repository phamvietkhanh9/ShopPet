package com.example.shoppet.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BillsDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String user;
    private String phone;
    private String display_name;
    private String address;
    private double total;
    private int quanty;
    private String note;
    private String name_product;
    private long id_product;
    private long id_bills;
    private String name;
    private long id_color;

    public BillsDto() {
    }

    public BillsDto(long id, String user, String phone, String display_name, String address, double total, int quanty, String note, String name_product, long id_product, long id_bills, String name, long id_color) {
        this.id = id;
        this.user = user;
        this.phone = phone;
        this.display_name = display_name;
        this.address = address;
        this.total = total;
        this.quanty = quanty;
        this.note = note;
        this.name_product = name_product;
        this.id_product = id_product;
        this.id_bills = id_bills;
        this.name = name;
        this.id_color = id_color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public long getId_product() {
        return id_product;
    }

    public void setId_product(long id_product) {
        this.id_product = id_product;
    }

    public long getId_bills() {
        return id_bills;
    }

    public void setId_bills(long id_bills) {
        this.id_bills = id_bills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId_color() {
        return id_color;
    }

    public void setId_color(long id_color) {
        this.id_color = id_color;
    }
}
