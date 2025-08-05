package com.thuvien.ThuVien.controllers;

import com.thuvien.ThuVien.entitys.PhieuMuon;
import com.thuvien.ThuVien.model.request.PhieuMuonRequest;
import com.thuvien.ThuVien.model.response.ResponseObject;
import com.thuvien.ThuVien.services.PhieuMuonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/phieumuon")
@CrossOrigin(origins = "*",maxAge = 3600)
public class PhieuMuonControlle {

    @Autowired
    public PhieuMuonServices phieuMuonServices;

    @GetMapping("/")
    public ResponseEntity<ResponseObject> getListPhieu(@RequestBody PhieuMuonRequest phieuMuonRequest){
        List<PhieuMuon> lst = phieuMuonServices.getAllListPhieu(phieuMuonRequest);
        if(!lst.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseObject.builder()
                            .status("OK")
                            .message("Select all Phieu muon OK")
                            .data(lst)
                            .build());
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)  // hoặc BAD_REQUEST/NOT_FOUND tuỳ
                    .body(ResponseObject.builder()
                            .status("ERROR")
                            .message("Select Phieu Muon thất bại.")
                            .data(null)
                            .build());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createPhieuMuon (@RequestBody PhieuMuonRequest phieuMuonRequest){
        PhieuMuon phieuMuon = phieuMuonServices.createPhieuMuon(phieuMuonRequest);
        if(phieuMuon != null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseObject.builder()
                            .status("OK")
                            .message("Tao Phieu Thanh Cong")
                            .data(phieuMuon)
                            .build());
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)  // hoặc BAD_REQUEST/NOT_FOUND tuỳ
                    .body(ResponseObject.builder()
                            .status("ERROR")
                            .message("Tao Phieu That Bai")
                            .data(null)
                            .build());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseObject> updatePhieuMuon (@PathVariable String id,
                                                           @RequestParam(name = "status") String status){
        PhieuMuon phieuMuon = phieuMuonServices.updatePhieuMuon(id, status);

        if(phieuMuon != null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseObject.builder()
                            .status("OK")
                            .message("Update Phieu Thanh Cong")
                            .data(phieuMuon)
                            .build());
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)  // hoặc BAD_REQUEST/NOT_FOUND tuỳ
                    .body(ResponseObject.builder()
                            .status("ERROR")
                            .message("Update Phieu That Bai")
                            .data(null)
                            .build());
        }
    }
}
