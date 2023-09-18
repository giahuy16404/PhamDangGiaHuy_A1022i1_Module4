package com.example.thi.model;

import javax.persistence.*;

@Entity
public class DoanhNghiep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doanh_nghiep_id")
    private Long id;
    private String name;
    private String linhVuc;
    private String phone;
    private String email;
    private String diaChi;

    public DoanhNghiep() {
    }

    public DoanhNghiep(Long id, String name, String linhVuc, String phone, String email, String diaChi) {
        this.id = id;
        this.name = name;
        this.linhVuc = linhVuc;
        this.phone = phone;
        this.email = email;
        this.diaChi = diaChi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
