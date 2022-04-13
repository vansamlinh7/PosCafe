package com.fasttrack.cafe.tmcafes.model;

import javax.persistence.*;

@Entity
@Table(name = "thanhphan")
public class ThanhPhan {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MaSP")
    private String maSP;

    @Column(name = "MaDVT")
    private String maDVT;

    @Column(name = "MaTP")
    private String maTP;

    @Column(name = "MaDVTTP")
    private String maDVTTP;

    @Column(name = "SoLuong")
    private Float soLuong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaDVT() {
        return maDVT;
    }

    public void setMaDVT(String maDVT) {
        this.maDVT = maDVT;
    }

    public String getMaTP() {
        return maTP;
    }

    public void setMaTP(String maTP) {
        this.maTP = maTP;
    }

    public String getMaDVTTP() {
        return maDVTTP;
    }

    public void setMaDVTTP(String maDVTTP) {
        this.maDVTTP = maDVTTP;
    }

    public Float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Float soLuong) {
        this.soLuong = soLuong;
    }
}
