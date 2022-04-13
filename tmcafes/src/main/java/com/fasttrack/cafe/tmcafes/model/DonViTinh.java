package com.fasttrack.cafe.tmcafes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "donvitinh")
public class DonViTinh {
    @Id
    @Column(name = "MaDVT")
    private String maDVT;

    @Column(name = "MacDinh")
    private Integer macDinh;

    public String getMaDVT() {
        return maDVT;
    }

    public void setMaDVT(String maDVT) {
        this.maDVT = maDVT;
    }

    public Integer getMacDinh() {
        return macDinh;
    }

    public void setMacDinh(Integer macDinh) {
        this.macDinh = macDinh;
    }
}
