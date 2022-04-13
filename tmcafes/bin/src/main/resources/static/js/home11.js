var tabsVerticalInner = $('#accordian');
var selectorVerticalInner = $('#accordian').find('li').length;
var activeItemVerticalInner = tabsVerticalInner.find('.active');
var activeWidthVerticalHeight = activeItemVerticalInner.innerHeight();
var activeWidthVerticalWidth = activeItemVerticalInner.innerWidth();
var itemPosVerticalTop = activeItemVerticalInner.position();
var itemPosVerticalLeft = activeItemVerticalInner.position();
$(".selector-active").css({
    "top": itemPosVerticalTop.top + "px",
    "left": itemPosVerticalLeft.left + "px",
    "height": activeWidthVerticalHeight + "px",
    "width": activeWidthVerticalWidth + "px"
});

function notifyMenuChange() {
    $('.content .menu-content').hide();
    var refer = $('#accordian .active').attr("refer-for-menu");
    if (refer === '#contentGoiMon') {
        $('#contentGoiMon').show();
    } else if (refer === '#contentDonHang') {
        $('#contentDonHang').show();
    }
}


notifyMenuChange();

$("#accordian").on("click", "li", function (e) {
    $('#accordian ul li').removeClass("active");

    $(this).addClass('active');
    var activeWidthVerticalHeight = $(this).innerHeight();
    var activeWidthVerticalWidth = $(this).innerWidth();
    var itemPosVerticalTop = $(this).position();
    var itemPosVerticalLeft = $(this).position();
    $(".selector-active").css({
        "top": itemPosVerticalTop.top + "px",
        "left": itemPosVerticalLeft.left + "px",
        "height": activeWidthVerticalHeight + "px",
        "width": activeWidthVerticalWidth + "px"
    });

    notifyMenuChange();
});

var donHangList = [];

var ban = 0;
var ghichu = '';
var giamGiaDH = 0;
loaiGiamGiaDH = 'VND';
var total = 0;


<!--btn giam gia-->
function giamgia(phantram) {
    $('#input-giamGia').val(phantram);

    $('#phanTram').prop("checked", true);
}

<!--btn giam gia-->
function giamgia2(vnd) {
    $('#input-giamGia').val(vnd);

    $('#VND').prop("checked", true);
}


function themSP(id, ten, gia) {
    for (var index = 0; index < donHangList.length; index++) {
        if (donHangList[index].maSP == id) {
            editDonHang(id);
            return;
        }
    }
    $(".btn-normal").attr("data-masp", id);
    $(".btn-normal").attr("data-tensp", ten);
    $(".btn-normal").attr("data-gia", gia);

    $("#soLuong").val(1);

    $('.themSP-ten').text(ten);
    $('.btn-normal-gia').text(gia);
    $('.themSP').modal('show');

}

function addDonHang() {
    var id = $(".themSP-radio input[type='radio'][name='loaiSP']:checked").attr('data-masp');
    for (var index = 0; index < donHangList.length; index++) {
        if (donHangList[index].maSP == id) {
            donHangList[index].maSP = $(".themSP-radio input[type='radio'][name='loaiSP']:checked").attr('data-masp');
            donHangList[index].tenSP = $(".themSP-radio input[type='radio'][name='loaiSP']:checked").attr('data-tensp');
            donHangList[index].gia = $(".themSP-radio input[type='radio'][name='loaiSP']:checked").attr('data-gia');
            donHangList[index].soLuong = $("#soLuong").val();
            donHangList[index].ghiChu = $("#ghiChu").val();
            donHangList[index].giamGia = $("#input-giamGia").val();
            donHangList[index].loaiGiam = $("input[type='radio'][name='giam']:checked").val();
            reloadDonHang();

            $('.themSP').modal('hide');
            return;
        }
    }
    var donHang = {
        maSP: $(".themSP-radio input[type='radio'][name='loaiSP']:checked").attr('data-masp'),
        tenSP: $(".themSP-radio input[type='radio'][name='loaiSP']:checked").attr('data-tensp'),
        gia: $(".themSP-radio input[type='radio'][name='loaiSP']:checked").attr('data-gia'),
        soLuong: $("#soLuong").val(),
        ghiChu: $("#ghiChu").val(),
        giamGia: $("#input-giamGia").val(),
        loaiGiam: $("input[type='radio'][name='giam']:checked").val()
    };
    donHangList.push(donHang);
    reloadDonHang();

    $('.themSP').modal('hide');

}

function editDonHang(id) {
    let donHang = donHangList.find((dh) => dh.maSP === id);
    $('.themSP-radio input[type="radio"][name="loaiSP"][data-masp="+donHang.maSP+"]').prop('checked', true);
    $('.themSP-ten').text(donHang.tenSP);
    $('#soLuong').text(donHang.soLuong);
    $("#ghiChu").val(donHang.ghiChu);
    $("#input-giamGia").val(donHang.giamGia);
    if (donHang.loaiGiam == "VND") {
        $("input[type='radio'][name='giam'][value='VND']").prop('checked', true);
    } else {
        $("input[type='radio'][name='giam'][value='phanTram']").prop('checked', true);
    }
    $('.themSP').modal('show');
}

function remove(id) {
    var removeIndex = donHangList.map(function (item) {
        return item.maSP;
    }).indexOf(id);

    donHangList.splice(removeIndex, 1);
    reloadDonHang();
}

function reloadDonHang() {
    var html = "";
    total = 0;
    for (var index = 0; index < donHangList.length; index++) {
        html += genItemDonHang(donHangList[index]);
        var donhang = donHangList[index];
        total += (parseInt(donhang.soLuong) * giaSauGiam(donhang.gia, donhang.giamGia, donhang.loaiGiam));
    }

    $('#giatien').text(formatTien(total) + "VND");
    $('#list-order').html(html);

}

function genItemDonHang(donHang) {
    var giaFormat = formatGia(donHang);
    if (donHang.giamGia != 0) {
        return `<li class="list-group-item list-group-item-action user-none px-1" onclick="editDonHang('${donHang.maSP}')">
                            <div class="row ">
                                <div class="col-1 ml-1">${donHang.soLuong}</div>
                                <div class="col-6 font-weight-bold">${donHang.tenSP}</div>
                                <div class="col-3 text-warning font-italic">${giaFormat}</div>
                                <div class="col-1 px-0">
                                    <i class="fas fa-times btn-x" onclick="remove('${donHang.maSP}')"></i>
                                </div>
                            </div>
                        </li>`;

    }
    return `<li class="list-group-item list-group-item-action user-none px-1" onclick="editDonHang('${donHang.maSP}')">
                            <div class="row ">
                                <div class="col-1 ml-1">${donHang.soLuong}</div>
                                <div class="col-6 font-weight-bold">${donHang.tenSP}</div>
                                <div class="col-3 font-italic">${giaFormat}</div>
                                <div class="col-1 px-0">
                                    <i class="fas fa-times btn-x" onclick="remove('${donHang.maSP}')"></i>
                                </div>
                            </div>
                        </li>`;
}

function formatGia(donHang) {
    var nStr;
    if (donHang.giamGia != 0) {
        if (donHang.loaiGiam == "VND") {
            nStr = parseInt(donHang.gia) - parseInt(donHang.giamGia);
        } else if (donHang.loaiGiam == "phanTram") {
            nStr = parseInt(donHang.gia) * ((100 - parseInt(donHang.giamGia)) / 100);
        }
    } else {
        nStr = donHang.gia;
    }

    nStr += '';
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
}

function formatTien(nStr) {
    nStr += '';
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
}

function giaSauGiam(gia, giamGia, loaiGiam) {
    if (giamGia != 0) {
        if (loaiGiam == "VND") {
            return parseInt(gia) - parseInt(giamGia);
        } else if (loaiGiam == "phanTram") {
            return parseInt(gia) * ((100 - parseInt(giamGia)) / 100);
        }
    } else {
        return parseInt(gia);
    }
}


function taoBan(soBan) {
    var html = '';
    for (var i = 1; i < soBan + 1; i++) {
        html += addBanHtml(i);
    }
    $('#listBan').html(html);

}

function addBanHtml(i) {
    return `<div class="chonban" onclick="banDuocChon(${i})" id="ban-${i}" data-ban="${i}" >
                  <span class="soban">${i}</span>
               </div>`;
}

taoBan(15);

function chonBan() {
    if (ban != 0) {
        $(".chonban").removeClass("ban-duoc-chon");
        $("#ban-" + ban).addClass("ban-duoc-chon");
        $('#modalChonBan').modal('show');
        return;
    }
    $('#modalChonBan').modal('show');
}

function banDuocChon(i) {
    $(".chonban").removeClass("ban-duoc-chon");
    $("#ban-" + i).addClass("ban-duoc-chon");
};

function sumitChonBan() {
    ban = $(".ban-duoc-chon").attr("data-ban");
    $("#btn-ban").text(ban + " - ");
    if (ban != 0) {
        $("#btn-ban").parent().addClass("btn-custom-checked");
    } else {
        $("btn-ban").parent().removeClass("btn-custom-checked");
    }
    $('#modalChonBan').modal('hide');
};

function ghiChuTong() {
    $("#ghiChuTong").val(ghichu);
    $('#modalGhiChu').modal('show');
};

function sumitGhiChuTong() {
    ghichu = $("#ghiChuTong").val();

    if (ghichu != '') {
        $("#btn-ghiChuTong").addClass("btn-custom-checked");
    } else {
        $("btn-ghiChuTong").addClass("btn-custom-checked");
    }
    $('#modalGhiChu').modal('hide');
};

$('#giamGiaDH').click(function () {
    $('.tienhang').text(formatTien(total) + "VND");
    if (giamGiaDH != 0) {
        if (loaiGiamGiaDH == "VND") {
            $('#soTienGiamDH').text("- " + giamGiaDH + "VND");
            $("#modalGiamGiaBody .thanhtoan").text(formatTien(total - giamGiaDH) + "VND");
        } else {
            $('#soTienGiamDH').text("- " + giamGiaDH + "%");
            $("#modalGiamGiaBody .thanhtoan").text(formatTien(total * ((100 - giamGiaDH) / 100)) + "VND");
        }

    } else {
        $("#modalGiamGiaBody .thanhtoan").text(formatTien(total));
    }

    $('#modalGiamGia').modal('show');
});

function giamDH(so, loai) {
    $("#modalGiamGiaBody input[type='number']").val(parseInt(so));
    if (loai === "VND") {
        $("#modalGiamGiaBody #giam-VND").prop('checked', true);
        $('#soTienGiamDH').text(formatTien("- " + parseInt(so)) + "VND");
        $("#modalGiamGiaBody .thanhtoan").text(formatTien(total - so) + "VND");
    } else {
        $("#modalGiamGiaBody #giam-phanTram").prop('checked', true);
        $('#soTienGiamDH').text("- " + parseInt(so) + "%");
        $("#modalGiamGiaBody .thanhtoan").text(formatTien(total * ((100 - so) / 100)) + "VND");
    }

};

$("#modalGiamGiaBody input[type='number'],#modalGiamGiaBody input[type='radio'] ").on('keyup keypress blur change', function () {
    var loaiGiam = $("#modalGiamGiaBody input[type='radio'][name='loaiGiamGiaDH']:checked").val();
    var so = $("#modalGiamGiaBody input[type='number']").val();
    if (loaiGiam == "VND") {
        $('#soTienGiamDH').text("- " + formatTien(so) + "VND");
        $("#modalGiamGiaBody .thanhtoan").text(formatTien(total - so) + "VND");
    } else {
        $('#soTienGiamDH').text("- " + so + "%");
        $("#modalGiamGiaBody .thanhtoan").text(formatTien(total * ((100 - so) / 100)) + "VND");
    }

});

function submitGiamGiaDH() {
    giamGiaDH = parseInt($("#modalGiamGiaBody input[type='number']").val());
    loaiGiamGiaDH = $("#modalGiamGiaBody input[type='radio'][name='loaiGiamGiaDH']:checked").val();
    $('#modalGiamGia').modal('hide');
}

function thanhToan() {
    html = '';
    for (var index = 0; index < donHangList.length; index++) {
        var donHang = donHangList[index];
        var tongtien = parseInt(donHang.soLuong)*giaSauGiam(donHang.gia, donHang.giamGia, donHang.loaiGiam);
        html+= thanhToanHtml(donHang, index, tongtien);

    }
    $('#tableThanhToanBody').html(html);
    $('.show-ghiChu').val(ghichu);
    $('#thanhToan-giamGia').text(formatTien(giamGiaDH));
    $('#thanhToan-tongTien').text(formatTien(parseInt(total)));
    if(loaiGiamGiaDH=="VND"){
        $('#thanhTien').text(formatTien(parseInt(total)-parseInt(giamGiaDH)));
    }else if(loaiGiamGiaDH=="phanTram"){
        $('#thanhTien').text(formatTien(parseInt(total) * ( (100 - parseInt(giamGiaDH) / 100) )) );
    }
    $('#modalThanhToan').modal('show');
}

function thanhToanHtml(obj, i, tongtien) {
    return `<tr>
      <th scope="row">${i+1}</th>
      <td>${obj.tenSP}</td>
      <td>${obj.gia}</td>
      <td>${obj.soLuong}</td>
      <td>${obj.giamGia}</td>
      <td>${obj.loaiGiam}</td>
      <td>${tongtien}</td>
    </tr>`;

}
