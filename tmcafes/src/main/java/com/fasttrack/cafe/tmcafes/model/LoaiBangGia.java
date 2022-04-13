package com.fasttrack.cafe.tmcafes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaibanggia")
public class LoaiBangGia {
    @Id
    @Column(name = "MaBG")
    private String maBG;

    @Column(name = "TenBG")
    private String tenBG;

    @Column(name = "MacDinh")
    private Integer macDinh;

    public String getMaBG() {
        return maBG;
    }

    public void setMaBG(String maBG) {
        this.maBG = maBG;
    }

    public String getTenBG() {
        return tenBG;
    }

    public void setTenBG(String tenBG) {
        this.tenBG = tenBG;
    }

    public Integer getMacDinh() {
        return macDinh;
    }

    public void setMacDinh(Integer macDinh) {
        this.macDinh = macDinh;
    }
}
