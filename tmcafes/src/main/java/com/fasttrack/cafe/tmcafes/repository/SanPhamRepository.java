package com.fasttrack.cafe.tmcafes.repository;

import com.fasttrack.cafe.tmcafes.dto.HangHoaDTO;
import com.fasttrack.cafe.tmcafes.dto.LoaiBangGiaDTO;
import com.fasttrack.cafe.tmcafes.dto.NhomHangDTO;
import com.fasttrack.cafe.tmcafes.dto.SanPhamDTO;
import com.fasttrack.cafe.tmcafes.model.LoaiBangGia;
import com.fasttrack.cafe.tmcafes.model.NhomHang;
import com.fasttrack.cafe.tmcafes.model.SanPham;
import com.fasttrack.cafe.tmcafes.service.SequenceGenerate;
import com.fasttrack.cafe.tmcafes.untils.ResultDelNhomHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
public class SanPhamRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    SequenceGenerate sq;

    public SanPham addSP(SanPhamDTO dto) {
        SanPham sp = new SanPham();
        sp.setMaSP(sq.incrementMaSP());
        sp.setTenSP(dto.getTenSP());
        sp.setMaNhom(dto.getMaNhom());
        sp.setMaDVT(dto.getMaDVT());
        sp.setSldk(dto.getSldk());
        sp.setGtdk(dto.getGtdk());
        sp.setIsMenu(0);
            entityManager.persist(sp);
            return sp;
    }
    public List<SanPham> getAllSP(){
        try {
            TypedQuery<SanPham> sp = entityManager.createQuery("SELECT u FROM SanPham u", SanPham.class);
            return sp.getResultList();
        }catch (NullPointerException e){
            return null;
        }
    }

    public List<NhomHang> getAllNH(){
        try {
            TypedQuery<NhomHang> listNH =  entityManager.createQuery("SELECT n FROM NhomHang n ORDER BY n.maCha", NhomHang.class);
            return listNH.getResultList();

        }catch (Exception e){
            return null;
        }

    }
    //add nhóm hàng
    public NhomHang addNhomHang(NhomHangDTO dto) {
        NhomHang nh = new NhomHang();
        nh.setMaNhom(sq.incrementMaNhom());
        nh.setTenNhom(dto.getTenNhom());
        nh.setLoaiNhom(dto.getLoaiNhom());
        nh.setMaCha(dto.getMaCha());
        entityManager.persist(nh);
        return nh;
    }

    //update nhóm hàng
    public NhomHang updateNhomHang(NhomHangDTO dto){
        NhomHang nh = entityManager.find(NhomHang.class, dto.getMaNhom());
        if(nh != null){
            nh.setTenNhom(dto.getTenNhom());
            nh.setLoaiNhom(dto.getLoaiNhom());
            nh.setMaCha(dto.getMaCha());
        }
        return nh;
    }
    //delete nhom hang
    public ResultDelNhomHang removeNhomHang(String maNhom) {
        Query checkUsedMaNhom = entityManager.createQuery("SELECT COUNT(nh.maNhom) FROM NhomHang nh WHERE nh.maCha IN(:maNhom)");
        checkUsedMaNhom.setParameter("maNhom", maNhom);
        Long count = (Long) checkUsedMaNhom.getResultList().get(0);
        if (count > 0) {
            return ResultDelNhomHang.USED;
        } else {
            try {
                NhomHang delObj = entityManager.find(NhomHang.class, maNhom);
                entityManager.remove(delObj);
                return ResultDelNhomHang.SUCCESS;
            } catch (Exception ex) {
                return ResultDelNhomHang.ERROR;
            }
        }
    }

    public List<HangHoaDTO> findSanPhamByName(String keyword) {
        try {
            String query = "SELECT new com.fasttrack.cafe.tmcafes.dto.HangHoaDTO(sp.maSP, sp.tenSP, sp.sldk, sp.gtdk, bg.donGia, nh.tenNhom as TenNhomHang, ndv.tenNhom as TenGroupSP, sp.groupID) FROM SanPham sp left join NhomDonViSP ndv on sp.groupID = ndv.ID LEFT JOIN ThuocTinhSanPham ttsp on ttsp.maSP = sp.maSP LEFT JOIN ThuocTinh tt on tt.ID = ttsp.maThuocTinh LEFT JOIN NhomHang nh on nh.maNhom = sp.maNhom LEFT JOIN BangGia bg on bg.maSP = sp.maSP";
            if (!StringUtils.isEmpty(keyword.trim())) {
                query += " WHERE sp.tenSP LIKE :keyword";
            }

            TypedQuery<HangHoaDTO> list = entityManager.createQuery(query, HangHoaDTO.class);
            if (!StringUtils.isEmpty(keyword.trim())) {
                list.setParameter("keyword", "%" + keyword.trim() + "%");
            }
            return list.getResultList();
        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }
}
