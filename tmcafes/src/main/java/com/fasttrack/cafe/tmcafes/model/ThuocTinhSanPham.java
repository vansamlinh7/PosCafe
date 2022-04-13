package com.fasttrack.cafe.tmcafes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ThuocTinhSanPham")
public class ThuocTinhSanPham implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MaThuocTinh", nullable = false)
    private Integer maThuocTinh;

    @Id
    @Column(name = "MaSP", nullable = false)
    private String maSP;

    public void setMaThuocTinh(Integer maThuocTinh) {
        this.maThuocTinh = maThuocTinh;
    }

    public Integer getMaThuocTinh() {
        return maThuocTinh;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaSP() {
        return maSP;
    }

    @Override
    public String toString() {
        return "ThuocTinhSanPham{" +
                "maThuocTinh=" + maThuocTinh + '\'' +
                "maSP=" + maSP + '\'' +
                '}';
    }
}
