package com.fasttrack.cafe.tmcafes.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "NhomDonViSP")
public class NhomDonViSP implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "TenNhom", nullable = false)
    private String tenNhom;

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    @Override
    public String toString() {
        return "NhomDonViSP{" +
                "ID=" + ID + '\'' +
                "tenNhom=" + tenNhom + '\'' +
                '}';
    }
}
