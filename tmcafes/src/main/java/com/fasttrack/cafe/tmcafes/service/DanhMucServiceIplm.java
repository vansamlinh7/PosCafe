package com.fasttrack.cafe.tmcafes.service;

import com.fasttrack.cafe.tmcafes.dto.DonViTinhDTO;
import com.fasttrack.cafe.tmcafes.dto.KhuVucDTO;
import com.fasttrack.cafe.tmcafes.dto.LoaiBangGiaDTO;
import com.fasttrack.cafe.tmcafes.model.DonViTinh;
import com.fasttrack.cafe.tmcafes.model.KhuVuc;
import com.fasttrack.cafe.tmcafes.model.LoaiBangGia;
import com.fasttrack.cafe.tmcafes.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DanhMucServiceIplm implements DanhMucService {
    @Autowired
    DanhMucRepository repository;

    @Override
    public List<LoaiBangGia> getAllLoaiBangGia() {
        return repository.getAllLoaiBangGia();
    }

    @Override
    public boolean check(LoaiBangGiaDTO dto) {
        return repository.check(dto);
    }

    @Override
    @Transactional
    public void addLoaiBangGia(LoaiBangGiaDTO dto) {
        repository.addLoaiBangGia(dto);
    }

    @Override
    @Transactional
    public LoaiBangGia deleteLoaiBangGia(String maBG) {
        return repository.deleteLoaiBangGia(maBG);
    }

   /* @Override
    public LoaiBangGia getLoaiBangGia(String maBG) {
        return repository.getLoaiBangGia(maBG);
    }*/

    @Override
    @Transactional
    public LoaiBangGia editloaiBangGia(LoaiBangGiaDTO dto) {
        return repository.editLoaiBangGia(dto);
    }

    @Override
    public List<DonViTinh> getAllDVT() {
        return repository.getAllDVT();
    }

    @Override
    public Boolean checkDVT(DonViTinhDTO dto) {
        return repository.checkDVT(dto);
    }

    @Override
    @Transactional
    public void addDVT(DonViTinhDTO dto) {
        repository.addDVT(dto);
    }

    @Override
    @Transactional
    public DonViTinh updateDVT(DonViTinhDTO dto) {
        return repository.updateDVT(dto);
    }

    @Override
    @Transactional
    public DonViTinh deleteDVT(String maDVT) {
        return repository.deleteDVT(maDVT);
    }

    @Override
    public List<KhuVuc> getAllKV() {
        return repository.getAllKV();
    }

    @Override
    public Boolean checkKV(KhuVucDTO dto) {
        return repository.checkKV(dto);
    }

    @Override
    @Transactional
    public KhuVuc addKV(KhuVucDTO dto) {
        return repository.addKV(dto);
    }

    @Override
    @Transactional
    public KhuVuc deleteKV(String maKV) {
        return repository.deleteKV(maKV);
    }
}
