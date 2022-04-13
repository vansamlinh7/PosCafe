package com.fasttrack.cafe.tmcafes.service;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class SequenceGenerate {

    @PersistenceContext
    private EntityManager entityManager;

    public String incrementMaNhom() {
        String defaultVal = "00000";
        Query q = entityManager.createQuery("select max(cast(h.maNhom as int)) from NhomHang h");
        Integer max = (Integer) q.getResultList().get(0);
        if (max != null) {
            max += 1;
            StringBuilder seq = new StringBuilder(String.valueOf(max)); //2
            for (int i = seq.length(); i < defaultVal.length(); i++) {
                seq.insert(0, "0");
            }
            return seq.toString();
        }
        return defaultVal;
    }
    public String incrementMaSP() {
        String defaultVal = "00000";
        Query q = entityManager.createQuery("select max(cast(h.maSP as int)) from SanPham h");
        Integer max = (Integer) q.getResultList().get(0);
        if (max != null) {
            max += 1;
            StringBuilder seq = new StringBuilder(String.valueOf(max)); //2
            for (int i = seq.length(); i < defaultVal.length(); i++) {
                seq.insert(0, "0");
            }
            return seq.toString();
        }
        return defaultVal;
    }

}
