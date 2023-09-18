package com.example.thi.model;

import javax.persistence.*;

@Entity
public class DuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "du_an_id")
    private Long id;
    private String code;
    private String tenDuAn;
    @ManyToOne
    @JoinColumn(name = "doanh_nghiep_id",nullable = false,referencedColumnName = "doanh_nghiep_id")
    private DoanhNghiep doanhNghiep;
    private float kinhPhiYeuCau;

    @Column(columnDefinition = "TEXT")
    private String moTa;
    private int thoiGianDangKy;
    private String ngayDangKy;
    private float chiPhi;

    public DuAn() {
    }

    public DuAn(Long id, String code, String tenDuAn, DoanhNghiep doanhNghiep, float kinhPhiYeuCau, String moTa, int thoiGianDangKy, String ngayDangKy, float chiPhi) {
        this.id = id;
        this.code = code;
        this.tenDuAn = tenDuAn;
        this.doanhNghiep = doanhNghiep;
        this.kinhPhiYeuCau = kinhPhiYeuCau;
        this.moTa = moTa;
        this.thoiGianDangKy = thoiGianDangKy;
        this.ngayDangKy = ngayDangKy;
        this.chiPhi = chiPhi;
    }

    public float getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(float chiPhi) {
        this.chiPhi = chiPhi;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DoanhNghiep getDoanhNghiep() {
        return doanhNghiep;
    }

    public void setDoanhNghiep(DoanhNghiep doanhNghiep) {
        this.doanhNghiep = doanhNghiep;
    }

    public float getKinhPhiYeuCau() {
        return kinhPhiYeuCau;
    }

    public void setKinhPhiYeuCau(float kinhPhiYeuCau) {
        this.kinhPhiYeuCau = kinhPhiYeuCau;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getThoiGianDangKy() {
        return thoiGianDangKy;
    }

    public void setThoiGianDangKy(int thoiGianDangKy) {
        this.thoiGianDangKy = thoiGianDangKy;
    }

    public String getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
}
