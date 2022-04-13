package com.fasttrack.cafe.tmcafes.model;

import javax.persistence.*;

@Entity
@Table(name = "banggia")
public class BangGia {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "MaSP")
    private String maSP;

    @Column(name = "MaBG")
    private String maBG;

    @Column(name = "DonGia")
    private Float donGia;

    @Column(name = "Giam")
    private Float giam;

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

    public String getMaBG() {
        return maBG;
    }

    public void setMaBG(String maBG) {
        this.maBG = maBG;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public Float getGiam() {
        return giam;
    }

    public void setGiam(Float giam) {
        this.giam = giam;
    }
}
