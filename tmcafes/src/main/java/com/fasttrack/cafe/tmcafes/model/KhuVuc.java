package com.fasttrack.cafe.tmcafes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khuvuc")
public class KhuVuc {
    @Id
    @Column(name = "maKV")
    private String maKV;

    @Column(name = "tenKV")
    private String tenKV;

    public String getMaKV() {
        return maKV;
    }

    public void setMaKV(String maKV) {
        this.maKV = maKV;
    }

    public String getTenKV() {
        return tenKV;
    }

    public void setTenKV(String tenKV) {
        this.tenKV = tenKV;
    }
}
