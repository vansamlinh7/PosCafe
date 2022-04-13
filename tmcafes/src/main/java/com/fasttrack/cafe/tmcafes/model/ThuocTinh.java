package com.fasttrack.cafe.tmcafes.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ThuocTinh")
public class ThuocTinh implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "TenThuocTinh", nullable = false)
    private String tenThuocTinh;

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setTenThuocTinh(String tenThuocTinh) {
        this.tenThuocTinh = tenThuocTinh;
    }

    public String getTenThuocTinh() {
        return tenThuocTinh;
    }

    @Override
    public String toString() {
        return "ThuocTinh{" +
                "ID=" + ID + '\'' +
                "tenThuocTinh=" + tenThuocTinh + '\'' +
                '}';
    }
}
