package com.fasttrack.cafe.tmcafes.repository;

import com.fasttrack.cafe.tmcafes.dto.DonViTinhDTO;
import com.fasttrack.cafe.tmcafes.dto.KhuVucDTO;
import com.fasttrack.cafe.tmcafes.dto.LoaiBangGiaDTO;
import com.fasttrack.cafe.tmcafes.model.DonViTinh;
import com.fasttrack.cafe.tmcafes.model.KhuVuc;
import com.fasttrack.cafe.tmcafes.model.LoaiBangGia;
import com.fasttrack.cafe.tmcafes.model.SanPham;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DanhMucRepository {
    @PersistenceContext
    EntityManager entityManager;

    public boolean check(LoaiBangGiaDTO dto) {
        try {
            if (dto.getMaBG() != null && !dto.getMaBG().trim().isEmpty()) {

                TypedQuery<LoaiBangGia> lbg = entityManager.createQuery("SELECT u FROM LoaiBangGia u WHERE u.maBG= :maBG", LoaiBangGia.class);
                lbg.setParameter("maBG", dto.getMaBG());
                if (lbg.getSingleResult() != null) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }
    // get all Loai Bang Gia
    public List<LoaiBangGia> getAllLoaiBangGia() {
        try {
            TypedQuery<LoaiBangGia> lbg = entityManager.createQuery("SELECT u FROM LoaiBangGia u", LoaiBangGia.class);
            return lbg.getResultList();
        } catch (NullPointerException e) {
            return null;
        }
    }
    // thêm 1 hàng trong Loại Bảng Giá
    public void addLoaiBangGia(LoaiBangGiaDTO dto) {
        LoaiBangGia lbg = new LoaiBangGia();
        lbg.setMaBG(dto.getMaBG());
        lbg.setTenBG(dto.getTenBG());
        if (dto.getMacDinh()) {
            lbg.setMacDinh(1);
            setOnlyDefault(dto.getMaBG());
        } else {
            lbg.setMacDinh(0);
        }
        entityManager.persist(lbg);
    }
    // xóa 1 hàng trong Loại Bảng Giá
    public LoaiBangGia deleteLoaiBangGia(String maBG) {
        LoaiBangGia lbg = entityManager.find(LoaiBangGia.class, maBG);
        if (lbg != null) {
            entityManager.remove(lbg);
        }
        return lbg;
    }
    /*//lấy  1 hàng trong Loại Bảng Giá qua mã
    public LoaiBangGia getLoaiBangGia(String maBG) {
        LoaiBangGia lbg = entityManager.find(LoaiBangGia.class, maBG);
        return lbg;
    }*/
    private boolean setOnlyDefault(String id) {
        Query query = entityManager.createQuery("UPDATE LoaiBangGia bg SET bg.macDinh = 0 WHERE bg.maBG NOT IN (:maBG)");
        query.setParameter("maBG", id);
        return query.executeUpdate() > 0;
    }
    // update Loại Bảng Giá
    public LoaiBangGia editLoaiBangGia(LoaiBangGiaDTO dto) {
        LoaiBangGia lbg = entityManager.find(LoaiBangGia.class, dto.getMaBG());
        if (lbg != null) {
            lbg.setTenBG(dto.getTenBG());
            lbg.setMacDinh(dto.getMacDinh() ? 1 : 0);
            if (dto.getMacDinh()) {
                setOnlyDefault(dto.getMaBG());
            }
        }
        return lbg;
    }

    //get all danh mục đơn vị tính
    public List<DonViTinh> getAllDVT() {
        try {
            TypedQuery<DonViTinh> dvt = entityManager.createQuery("SELECT u FROM DonViTinh u", DonViTinh.class);
            return dvt.getResultList();
        } catch (NullPointerException e) {
            return null;
        }
    }
    //kiem tra id DVT
    public boolean checkDVT(DonViTinhDTO dto) {
        try {
            if (dto.getMaDVT() != null && !dto.getMaDVT().trim().isEmpty()) {

                TypedQuery<DonViTinh> dvt = entityManager.createQuery("SELECT u FROM DonViTinh u WHERE u.maDVT= :maDVT", DonViTinh.class);
                dvt.setParameter("maDVT", dto.getMaDVT());
                if (dvt.getSingleResult() != null) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }
    private boolean setOnlyDefaultDVT(String id) {
        Query query = entityManager.createQuery("UPDATE DonViTinh dvt SET dvt.macDinh = 0 WHERE dvt.maDVT NOT IN (:maDVT)");
        query.setParameter("maDVT", id);
        return query.executeUpdate() > 0;
    }
    //thêm 1 đơn vị tính
    public void addDVT(DonViTinhDTO dto) {
        DonViTinh dvt = new DonViTinh();
        dvt.setMaDVT(dto.getMaDVT());
        if (dto.getMacDinh() == null) {
            dvt.setMacDinh(0);
        } else {
            dvt.setMacDinh(1);
            setOnlyDefaultDVT(dto.getMaDVT());
        }
        entityManager.persist(dvt);
    }
    // update DVT
    public DonViTinh updateDVT(DonViTinhDTO dto) {
        DonViTinh dvt = entityManager.find(DonViTinh.class, dto.getMaDVT());
        if (dvt != null) {
            dvt.setMaDVT(dto.getMaDVT());
            if (dto.getMacDinh() == null) {
                dvt.setMacDinh(0);
            } else {
                dvt.setMacDinh(1);
                setOnlyDefaultDVT(dto.getMaDVT());
            }
        }
        return dvt;
    }
    // xóa 1 đơn vị tính
    public DonViTinh deleteDVT(String maDVT) {
        DonViTinh dvt = entityManager.find(DonViTinh.class, maDVT);
        if (dvt != null) {
            entityManager.remove(dvt);
        }
        return dvt;
    }

    //get all khu vuc
    public List<KhuVuc> getAllKV() {
        try {
            TypedQuery<KhuVuc> kv = entityManager.createQuery("SELECT u FROM KhuVuc u", KhuVuc.class);
            return kv.getResultList();
        } catch (NullPointerException e) {
            return null;
        }
    }
    public boolean checkKV(KhuVucDTO dto) {
        try {
            if (dto.getMaKV() != null && !dto.getMaKV().trim().isEmpty()) {

                TypedQuery<KhuVuc> kv = entityManager.createQuery("SELECT u FROM KhuVuc u WHERE u.maKV= :maKV", KhuVuc.class);
                kv.setParameter("maKV", dto.getMaKV());
                if (kv.getSingleResult() != null) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return true;
        }
    }
    //thêm khu vực
    public KhuVuc addKV(KhuVucDTO dto) {
        KhuVuc kv = new KhuVuc();
        kv.setMaKV(dto.getMaKV());
        kv.setTenKV(dto.getTenKV());
        entityManager.persist(kv);
        return kv;
    }

    // xóa 1 khu vuc
    public KhuVuc deleteKV(String maKV) {
        KhuVuc kv = entityManager.find(KhuVuc.class, maKV);
        if (kv != null) {
            entityManager.remove(kv);
        }
        return kv;
    }

}
