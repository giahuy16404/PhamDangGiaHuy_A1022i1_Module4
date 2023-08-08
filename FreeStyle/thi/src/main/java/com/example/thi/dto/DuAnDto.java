package com.example.thi.dto;

import com.example.thi.model.DoanhNghiep;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DuAnDto implements Validator {
    private Long id;
    private String code;
    private String tenDuAn;

    private DoanhNghiep doanhNghiep;
    private float kinhPhiYeuCau;

    private String moTa;
    private String thoiGianDangKy;
    private String ngayDangKy;

    public DuAnDto() {
    }

    public DuAnDto(Long id, String code, String tenDuAn, DoanhNghiep doanhNghiep, float kinhPhiYeuCau, String moTa, String thoiGianDangKy, String ngayDangKy) {
        this.id = id;
        this.code = code;
        this.tenDuAn = tenDuAn;
        this.doanhNghiep = doanhNghiep;
        this.kinhPhiYeuCau = kinhPhiYeuCau;
        this.moTa = moTa;
        this.thoiGianDangKy = thoiGianDangKy;
        this.ngayDangKy = ngayDangKy;
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

    public String getThoiGianDangKy() {
        return thoiGianDangKy;
    }

    public void setThoiGianDangKy(String thoiGianDangKy) {
        this.thoiGianDangKy = thoiGianDangKy;
    }

    public String getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
