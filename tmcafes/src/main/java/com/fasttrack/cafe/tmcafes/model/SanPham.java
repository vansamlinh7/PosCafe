package com.fasttrack.cafe.tmcafes.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @Column(name = "MaSP")
    private String maSP;

    @Column(name = "MaNhom")
    private String maNhom;

    @Column(name = "TenSP")
    private String tenSP;

    @Column(name = "MaDVT")
    private String maDVT;

    @Column(name = "SLDK")
    private Float sldk;

    @Column(name = "GTDK")
    private Float gtdk;

    @Column(name = "IsMenu")
    @ColumnDefault("0")
    private Integer isMenu;

    @Column(name = "GroupID")
    private String groupID;

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaDVT() {
        return maDVT;
    }

    public void setMaDVT(String maDVT) {
        this.maDVT = maDVT;
    }

    public Float getSldk() {
        return sldk;
    }

    public void setSldk(Float sldk) {
        this.sldk = sldk;
    }

    public Float getGtdk() {
        return gtdk;
    }

    public void setGtdk(Float gtdk) {
        this.gtdk = gtdk;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
}
