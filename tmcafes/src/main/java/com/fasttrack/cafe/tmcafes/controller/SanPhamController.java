package com.fasttrack.cafe.tmcafes.controller;

import com.fasttrack.cafe.tmcafes.dto.HangHoaDTO;
import com.fasttrack.cafe.tmcafes.dto.NhomHangDTO;
import com.fasttrack.cafe.tmcafes.dto.SanPhamDTO;
import com.fasttrack.cafe.tmcafes.model.NhomHang;
import com.fasttrack.cafe.tmcafes.model.SanPham;
import com.fasttrack.cafe.tmcafes.service.DanhMucService;
import com.fasttrack.cafe.tmcafes.service.SanPhamService;
import com.fasttrack.cafe.tmcafes.untils.ResultDelNhomHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class SanPhamController {
    @Autowired
    SanPhamService service;

    @Autowired
    DanhMucService danhMucService;

    //tem san pham
    @RequestMapping(value = "/them-san-pham", method = RequestMethod.POST)
    public String themSanPhamzzz(@ModelAttribute("sanpham")SanPhamDTO dto, RedirectAttributes redirectAttributes) {
        SanPham sp = service.addSP(dto);
        if(sp!= null){
            redirectAttributes.addFlashAttribute("addSanPham", " Thêm nhóm [ "+sp.getTenSP()+" ] thành công!");
        }else{
            redirectAttributes.addFlashAttribute("addSanPham", " Thêm nhóm [ "+sp.getTenSP()+" ] thất bại!");
        }
        return "redirect:/sanpham";
    }

    @RequestMapping("/danhsachsanpham")
    public String dsSP(Model model){
        model.addAttribute("list", service.getAllSP());
        return"/sanpham/danhsachsanpham";
    }

    //rq tới trang sản phẩm
    @RequestMapping(value = "/sanpham")
    public String sanPham(Model model){
        model.addAttribute("sanPham", new SanPhamDTO());
        model.addAttribute("nhomHang", new NhomHangDTO());
        model.addAttribute("dssp", service.getAllSP());
        model.addAttribute("dsDVT", danhMucService.getAllDVT());
        return "/sanpham/nhomsanpham";
    }
    //ds sanpham
    @RequestMapping(value = "/list-san-pham")
    @ResponseBody
    public ResponseEntity<?> listSanPham(Model model){
        model.addAttribute("listSanPham", service.getAllSP());
        return new ResponseEntity<>(service.getAllSP(), HttpStatus.OK);
    }

    //ds nhóm hàng
    @RequestMapping(value = "/list-nhom-hang")
    @ResponseBody
    public ResponseEntity<?> listNhomHang(Model model){
        model.addAttribute("listNhomHang", service.getAllNH());
        return new ResponseEntity<>(service.getAllNH(), HttpStatus.OK);
    }

    // add nhóm hàng
    @RequestMapping(value = "/them-nhom-hang", method = RequestMethod.POST)
    public String addNhomHang(@ModelAttribute("nhomHang")NhomHangDTO dto, RedirectAttributes redirectAttributes){
        NhomHang nh =service.addNhomHang(dto);
        if(nh!= null){
            redirectAttributes.addFlashAttribute("addNhomHang", " Thêm nhóm [ "+nh.getTenNhom()+" ] thành công!");
        }else{
            redirectAttributes.addFlashAttribute("addNhomHang", " Thêm nhóm [ "+nh.getTenNhom()+" ] thất bại!");
        }
        return "redirect:/sanpham";

    }
    //update nhóm hàng
    @RequestMapping(value = "update-nhom-hang", method = RequestMethod.POST)
    public String updateNhomhang(@ModelAttribute("nhomHang") NhomHangDTO dto, RedirectAttributes redirectAttributes){
        NhomHang nh =service.updateNhomHang(dto);
        if(nh!= null){
            redirectAttributes.addFlashAttribute("updateNhomHang", " cập nhật nhóm [ "+nh.getTenNhom()+" ] thành công!");
        }else{
            redirectAttributes.addFlashAttribute("updateNhomHang", " cập nhật nhóm [ "+nh.getTenNhom()+" ]thất bại!");
        }
        return "redirect:/sanpham";
    }
    //delete nhóm hàng
    @RequestMapping("/delete-nhomhang/{maNhom}")
    public String deleteNhomHang(@PathVariable("maNhom") String maNhom, RedirectAttributes redirectAttributes){
        /// service de xoa
        ResultDelNhomHang rs = service.deleteNhomHang(maNhom);
        switch (rs) {
            case USED:
                redirectAttributes.addFlashAttribute("message", "Vui lòng xóa nhóm con trước khi xóa nhóm cha!");
                break;
            case ERROR:
                redirectAttributes.addFlashAttribute("message", "Xóa nhóm hàng thất bại!");
                break;
            case SUCCESS:
                redirectAttributes.addFlashAttribute("message", "Xóa nhóm hàng thành công!");
                break;
        }
        return "redirect:/sanpham";
    }

    //danhmuc test
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("sp", new SanPhamDTO());
        model.addAttribute("nh", new NhomHangDTO());
        model.addAttribute("listSP", service.getAllSP());
        model.addAttribute("listDVT", danhMucService.getAllDVT());
        model.addAttribute("listNH", service.getAllNH());

        return "/sanpham/test";
    }

    @RequestMapping("/test2")
    public String test2(Model model){
        return "/sanpham/test2";
    }


    @RequestMapping("/search")
    public String searchSanPham(@RequestParam("keyword") String keyword, Model model) {
        List<HangHoaDTO> result = service.searchHangHoa(keyword);
        Map<String, List<HangHoaDTO>> hangHoas = result.stream().collect(Collectors.groupingBy(HangHoaDTO::getGroupID));
        model.addAttribute("result", hangHoas);
        return "/pos/layout :: fragmentSanPham";
    }


}
