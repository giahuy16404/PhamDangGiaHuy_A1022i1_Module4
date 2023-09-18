package com.example.thi.dto;

import com.example.thi.model.DoanhNghiep;
import com.example.thi.model.DuAn;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DuAnDto implements Validator {
    private Long id;
    private String code;
    private String tenDuAn;

    private DoanhNghiep doanhNghiep;
    private float kinhPhiYeuCau;

    private String moTa;
    private int thoiGianDangKy;
    private String ngayDangKy;
    private float chiPhi;

    public DuAnDto() {
    }

    public DuAnDto(Long id, String code, String tenDuAn, DoanhNghiep doanhNghiep, float kinhPhiYeuCau, String moTa, int thoiGianDangKy, String ngayDangKy, float chiPhi) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        DuAnDto duAnDto = (DuAnDto) target;
        if (duAnDto.getTenDuAn().isEmpty()) {
            errors.rejectValue("tenDuAn", null, " không được để trống!");
        }
        if (duAnDto.getKinhPhiYeuCau() == 0) {
            errors.rejectValue("kinhPhiYeuCau", null, " không được để trống!");
        } else if (duAnDto.getKinhPhiYeuCau() < 3000000) {
            errors.rejectValue("kinhPhiYeuCau", null, "Lon hon 30 trieu vnd!");

        }
        if (duAnDto.getMoTa().isEmpty()) {
            errors.rejectValue("moTa", null, " không được để trống!");
        }
        if (duAnDto.getThoiGianDangKy() == 0) {
            errors.rejectValue("thoiGianDangKy", null, " không được để trống!");
        } else if (duAnDto.getThoiGianDangKy() < 1 || duAnDto.getThoiGianDangKy() > 12) {
            errors.rejectValue("thoiGianDangKy", null, " phair tuwf 1 ddeens 12!");
        }
    }
}
