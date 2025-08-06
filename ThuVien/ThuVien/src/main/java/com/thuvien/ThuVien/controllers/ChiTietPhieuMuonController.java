package com.thuvien.ThuVien.controllers;

import com.thuvien.ThuVien.entitys.ChiTietPhieuMuon;
import com.thuvien.ThuVien.model.request.ChiTietPhieuMuonRequest;
import com.thuvien.ThuVien.model.response.ResponseObject;
import com.thuvien.ThuVien.services.ChiTietPhieuMuonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/chitietphieumuon")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ChiTietPhieuMuonController {

    @Autowired
    private ChiTietPhieuMuonServices chiTietPhieuMuonServices;

    @GetMapping("/all/{id}")
    public ResponseEntity<ResponseObject> getAll(@PathVariable String id){
        List<ChiTietPhieuMuon> lst = chiTietPhieuMuonServices.getAll(id);
        if(!lst.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseObject.builder()
                            .status("OK")
                            .message("Chi tiet phieu muon OK")
                            .data(lst)
                            .build());
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)  // hoặc BAD_REQUEST/NOT_FOUND tuỳ
                    .body(ResponseObject.builder()
                            .status("ERROR")
                            .message("Select Chi tiet phieu muon thất bại.")
                            .data(null)
                            .build());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updateChiTietPhieuMuon(@RequestBody ChiTietPhieuMuonRequest chiTietPhieuMuonRequest,
                                                                @PathVariable String id){
        ChiTietPhieuMuon chiTietPhieuMuon = chiTietPhieuMuonServices.update(chiTietPhieuMuonRequest, id);

        if(chiTietPhieuMuon != null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseObject.builder()
                            .status("OK")
                            .message("Update thanh cong OK")
                            .data(chiTietPhieuMuon)
                            .build());
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)  // hoặc BAD_REQUEST/NOT_FOUND tuỳ
                    .body(ResponseObject.builder()
                            .status("ERROR")
                            .message("update that bai thất bại.")
                            .data(null)
                            .build());
        }
    }
}
