package com.fasttrack.cafe.tmcafes.dto;

public class HangHoaDTO {
    private String maSP;
    private String tenSP;
    private Float sldk;
    private Float gtdk;
    private Float donGia;
    private String tenNhomHang;
    private String tenGroupSP;
    private String groupID;

    public HangHoaDTO(String maSP, String tenSP, Float sldk, Float gtdk, Float donGia, String tenNhomHang, String tenGroupSP, String groupID) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.sldk = sldk;
        this.gtdk = gtdk;
        this.donGia = donGia;
        this.tenNhomHang = tenNhomHang;
        this.tenGroupSP = tenGroupSP;
        this.groupID = groupID;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Float getSldk() {
        return sldk;
    }

    public void setSldk(Float sldk) {
        this.sldk = sldk;
    }

    public Float getGtdk() {
        return gtdk;
    }

    public void setGtdk(Float gtdk) {
        this.gtdk = gtdk;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public String getTenNhomHang() {
        return tenNhomHang;
    }

    public void setTenNhomHang(String tenNhomHang) {
        this.tenNhomHang = tenNhomHang;
    }

    public String getTenGroupSP() {
        return tenGroupSP;
    }

    public void setTenGroupSP(String tenGroupSP) {
        this.tenGroupSP = tenGroupSP;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
}
