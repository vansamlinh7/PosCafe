package com.fasttrack.cafe.tmcafes.service;

import com.fasttrack.cafe.tmcafes.dto.DonViTinhDTO;
import com.fasttrack.cafe.tmcafes.dto.KhuVucDTO;
import com.fasttrack.cafe.tmcafes.dto.LoaiBangGiaDTO;
import com.fasttrack.cafe.tmcafes.model.DonViTinh;
import com.fasttrack.cafe.tmcafes.model.KhuVuc;
import com.fasttrack.cafe.tmcafes.model.LoaiBangGia;

import java.util.List;

public interface DanhMucService {
    //loại bảng giá
    public List<LoaiBangGia> getAllLoaiBangGia();

    public boolean check(LoaiBangGiaDTO dto);

    public void addLoaiBangGia(LoaiBangGiaDTO dto);

    public LoaiBangGia deleteLoaiBangGia(String maBG);

  /*  public LoaiBangGia getLoaiBangGia(String maBG);*/

    public LoaiBangGia editloaiBangGia(LoaiBangGiaDTO dto);

    //dơn vị tính
    public List<DonViTinh> getAllDVT();

    public Boolean checkDVT(DonViTinhDTO dto);

    public void addDVT(DonViTinhDTO dto);

    public DonViTinh updateDVT(DonViTinhDTO dto);

    public DonViTinh deleteDVT(String maDVT);

    //khu vuc
    public List<KhuVuc> getAllKV();

    public Boolean checkKV(KhuVucDTO dto);

    public KhuVuc addKV(KhuVucDTO dto);

    public KhuVuc deleteKV(String maKV);
}