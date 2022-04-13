package com.fasttrack.cafe.tmcafes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "nhomhang")
public class NhomHang implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaNhom")
    private String maNhom;

    @Column(name = "MaCha")
    private String maCha;

    @Column(name = "TenNhom")
    private String tenNhom;

    @Column(name = "LoaiNhom")
    private Integer loaiNhom;

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getMaCha() {
        return maCha;
    }

    public void setMaCha(String maCha) {
        this.maCha = maCha;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public Integer getLoaiNhom() {
        return loaiNhom;
    }

    public void setLoaiNhom(Integer loaiNhom) {
        this.loaiNhom = loaiNhom;
    }

    @Override
    public String toString() {
        return "NhomHang{" +
                "maNhom=" + maNhom + '\'' +
                "maCha=" + maCha + '\'' +
                "tenNhom=" + tenNhom + '\'' +
                "loaiNhom=" + loaiNhom + '\'' +
                '}';
    }
}

