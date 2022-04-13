package com.fasttrack.cafe.tmcafes.service;

import com.fasttrack.cafe.tmcafes.dto.HangHoaDTO;
import com.fasttrack.cafe.tmcafes.dto.NhomHangDTO;
import com.fasttrack.cafe.tmcafes.dto.SanPhamDTO;
import com.fasttrack.cafe.tmcafes.model.NhomHang;
import com.fasttrack.cafe.tmcafes.model.SanPham;
import com.fasttrack.cafe.tmcafes.repository.SanPhamRepository;
import com.fasttrack.cafe.tmcafes.untils.ResultDelNhomHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class SanPhamServiceIplm implements SanPhamService {
    @Autowired
    SanPhamRepository rep;

    @Override
    @Transactional
    public SanPham addSP(SanPhamDTO dto) {
        return rep.addSP(dto);
    }

    //danh sách sản phẩm
    @Override
    public List<SanPham> getAllSP() {

        return rep.getAllSP();
    }

    @Override
    @Transactional
    public NhomHang addNhomHang(NhomHangDTO dto) {
        return rep.addNhomHang(dto);
    }

    @Override
    public List<NhomHang> getAllNH() {
        return rep.getAllNH();
    }

    @Override
    @Transactional
    public NhomHang updateNhomHang(NhomHangDTO dto) {
        return rep.updateNhomHang(dto);
    }

    @Override
    @Transactional
    public ResultDelNhomHang deleteNhomHang(String maNhom) {
        return rep.removeNhomHang(maNhom);
    }

    @Transactional
    public List<HangHoaDTO> searchHangHoa(String keyword) {
        return rep.findSanPhamByName(keyword);
    }
}
