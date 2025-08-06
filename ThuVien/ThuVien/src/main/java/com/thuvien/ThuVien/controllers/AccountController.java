package com.thuvien.ThuVien.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/account")
@CrossOrigin(origins = "*",maxAge = 3600)
public class AccountController {
}
