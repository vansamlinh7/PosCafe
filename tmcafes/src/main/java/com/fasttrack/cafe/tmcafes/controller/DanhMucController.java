package com.fasttrack.cafe.tmcafes.controller;

import com.fasttrack.cafe.tmcafes.dto.DonViTinhDTO;
import com.fasttrack.cafe.tmcafes.dto.KhuVucDTO;
import com.fasttrack.cafe.tmcafes.dto.LoaiBangGiaDTO;
import com.fasttrack.cafe.tmcafes.model.DonViTinh;
import com.fasttrack.cafe.tmcafes.model.KhuVuc;
import com.fasttrack.cafe.tmcafes.model.LoaiBangGia;
import com.fasttrack.cafe.tmcafes.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DanhMucController {
    @Autowired
    DanhMucService service;

    //trang danh mục
    @RequestMapping("/danhmuc")
    public String danhmuc(Model model, @RequestParam(value = "tab", required = false) String tabName) {
        model.addAttribute("ListLoaiBangGia", service.getAllLoaiBangGia());
        model.addAttribute("loaiBangGia", new LoaiBangGiaDTO());

        model.addAttribute("listDVT", service.getAllDVT());
        model.addAttribute("dvt", new DonViTinhDTO());

        model.addAttribute("listKhuVuc", service.getAllKV());
        model.addAttribute("khuVuc", new KhuVucDTO());
        return "danhmuc/danhmuc";
    }

    // thêm loại bảng giá
    @RequestMapping(value = "/add-loai-bang-gia", method = RequestMethod.POST)
    public String addLoaiBangGia(@ModelAttribute("loaiBangGia") LoaiBangGiaDTO dto, RedirectAttributes redirectAttributes) {
        if (service.check(dto)) {
            service.addLoaiBangGia(dto);
            redirectAttributes.addFlashAttribute("lbg_add_success",dto.getMaBG());
            return "redirect:/danhmuc?tab=bang-gia";
        } else {
            redirectAttributes.addFlashAttribute("lbg_add_error",dto.getMaBG());

            return "redirect:/danhmuc?tab=bang-gia";
        }
    }
    //xóa 1 hàng trong Loại Bảng Giá qua mã bảng giá
    @RequestMapping(value = "/delete-loai-bang-gia", method = RequestMethod.GET)
    public String deleteLoaiBangGia(@RequestParam("maBG") String maBG, RedirectAttributes redirectAttributes) {
        LoaiBangGia lbg = service.deleteLoaiBangGia(maBG);
        if (lbg != null) {
            redirectAttributes.addFlashAttribute("lbg_delete_success", maBG);
        }else {
            redirectAttributes.addFlashAttribute("lbg_delete_error");
        }

        return "redirect:/danhmuc?tab=bang-gia";
    }
    //update Loại Bảng Giá
    @RequestMapping(value = "update-loai-bang-gia", method = RequestMethod.POST)
    public String editLoaiBangGia(@ModelAttribute("loaiBangGia") LoaiBangGiaDTO dto, RedirectAttributes redirectAttributes) {
        LoaiBangGia lbg = service.editloaiBangGia(dto);
        if (lbg != null) {
            redirectAttributes.addFlashAttribute("lbg_update_success", dto.getMaBG());
        } else {
            redirectAttributes.addFlashAttribute("lbg_update_error");
        }
        return "redirect:/danhmuc?tab=bang-gia";
    }


    //thêm 1 đơn vị tính
    @RequestMapping(value = "add-DVT", method = RequestMethod.POST)
    public String addDVT(@ModelAttribute("dvt") DonViTinhDTO dto, RedirectAttributes redirectAttributes) {
        if (service.checkDVT(dto)) {
            service.addDVT(dto);
            redirectAttributes.addFlashAttribute("dvt_add_success", dto.getMaDVT());
            return "redirect:/danhmuc?tab=don-vi-tinh";
        } else {
            redirectAttributes.addFlashAttribute("dvt_add_error", dto.getMaDVT());
            return "redirect:/danhmuc?tab=don-vi-tinh";
        }

    }
    //update Đơn Vị Tính
    @RequestMapping(value = "update-dvt", method = RequestMethod.POST)
    public String updateDVT(@ModelAttribute("dvt") DonViTinhDTO dto, RedirectAttributes redirectAttributes){
        DonViTinh dvt = service.updateDVT(dto);
        if(dvt != null){
            redirectAttributes.addFlashAttribute("dvt_update_success", dto.getMaDVT());
        }else {
            redirectAttributes.addFlashAttribute("dvt_update_error", dto.getMaDVT());
        }
        return "redirect:/danhmuc?tab=don-vi-tinh";
    }
    //xóa 1 hàng trong Đơn Vị Tính qua mã DVT
    @RequestMapping(value = "/delete-dvt", method = RequestMethod.GET)
    public String deleteDVT(@RequestParam("maDVT") String maDVT, RedirectAttributes redirectAttributes) {
        DonViTinh dvt = service.deleteDVT(maDVT);
        if(dvt != null){
            redirectAttributes.addFlashAttribute("dvt_delete_success", maDVT);
        }else{
            redirectAttributes.addFlashAttribute("dvt_delete_error");
        }
        return "redirect:/danhmuc?tab=don-vi-tinh";
    }

    //khu vực
    //thêm 1 khu vực
    @RequestMapping(value = "add-khu-vuc", method = RequestMethod.POST)
    public String addKhuVuc(@ModelAttribute("khuVuc") KhuVucDTO dto, RedirectAttributes redirectAttributes){
       if(service.checkKV(dto)){
           service.addKV(dto) ;
           redirectAttributes.addFlashAttribute("kv_add_success", dto.getMaKV());
       } else {
           redirectAttributes.addFlashAttribute("kv_add_error", dto.getMaKV());
       }
       return "redirect:/danhmuc?tab=khu-vuc";
    }
    //xóa 1 khu vực
    @RequestMapping(value = "/delete-khu-vuc", method = RequestMethod.GET)
    public String deleteKV(@RequestParam("maKV")String maKV, RedirectAttributes redirectAttributes){
        KhuVuc kv = service.deleteKV(maKV);
        if(maKV!=null){
            redirectAttributes.addFlashAttribute("kv_delete_success", maKV);
        }else {
            redirectAttributes.addFlashAttribute("kv_delete_error");
        }
        return "redirect:/danhmuc?tab=khu-vuc";

    }


}
