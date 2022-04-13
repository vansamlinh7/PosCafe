package com.fasttrack.cafe.tmcafes.service;

import com.fasttrack.cafe.tmcafes.dto.HangHoaDTO;
import com.fasttrack.cafe.tmcafes.dto.NhomHangDTO;
import com.fasttrack.cafe.tmcafes.dto.SanPhamDTO;
import com.fasttrack.cafe.tmcafes.model.NhomHang;
import com.fasttrack.cafe.tmcafes.model.SanPham;
import com.fasttrack.cafe.tmcafes.untils.ResultDelNhomHang;

import java.util.List;

public interface SanPhamService {
    //them sanpham
    public SanPham addSP(SanPhamDTO dto);

    public List<SanPham> getAllSP();



    //thêm nhóm hàng
    public NhomHang addNhomHang(NhomHangDTO dto);

    // get all NH
    public List<NhomHang> getAllNH();

    //update nhóm hàng
    public NhomHang updateNhomHang(NhomHangDTO dto);

    //delete nhóm hàng
    ResultDelNhomHang deleteNhomHang(String maNhom);

    List<HangHoaDTO> searchHangHoa(String keyword);
}
