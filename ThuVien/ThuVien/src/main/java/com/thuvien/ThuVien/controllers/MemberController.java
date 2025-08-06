package com.thuvien.ThuVien.controllers;

import com.thuvien.ThuVien.entitys.Members;
import com.thuvien.ThuVien.model.response.ResponseObject;
import com.thuvien.ThuVien.services.MemberServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/members")
@CrossOrigin(origins = "*",maxAge = 3600)
public class MemberController {
    @Autowired
    private MemberServices memberServices;

    @GetMapping("/")
    public ResponseEntity<ResponseObject> getAllMember(){
        List<Members> lst = memberServices.getAllMember();

        if(!lst.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseObject.builder()
                            .status("OK")
                            .message("Select all Members OK")
                            .data(lst)
                            .build());
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)  // hoặc BAD_REQUEST/NOT_FOUND tuỳ
                    .body(ResponseObject.builder()
                            .status("ERROR")
                            .message("Select all members thất bại.")
                            .data(null)
                            .build());
        }
    }

}
