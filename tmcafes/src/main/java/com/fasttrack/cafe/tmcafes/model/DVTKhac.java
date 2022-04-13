package com.fasttrack.cafe.tmcafes.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DVTKhac")
public class DVTKhac implements Serializable {

    //data transfer object

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "MaSP", nullable = false)
    private String maSP;

    @Column(name = "MaDVT", nullable = false)
    private String maDVT;

    @Column(name = "QuyDoi", nullable = false)
    private Float quyDoi;

    @Column(name = "isMenu", nullable = false)
    private Integer isMenu;

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaDVT(String maDVT) {
        this.maDVT = maDVT;
    }

    public String getMaDVT() {
        return maDVT;
    }

    public void setQuyDoi(Float quyDoi) {
        this.quyDoi = quyDoi;
    }

    public Float getQuyDoi() {
        return quyDoi;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    @Override
    public String toString() {
        return "DVTKhac{" +
                "ID=" + ID + '\'' +
                "maSP=" + maSP + '\'' +
                "maDVT=" + maDVT + '\'' +
                "quyDoi=" + quyDoi + '\'' +
                "isMenu=" + isMenu + '\'' +
                '}';
    }
}
