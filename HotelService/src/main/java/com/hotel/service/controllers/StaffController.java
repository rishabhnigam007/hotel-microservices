package com.hotel.service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping("/allstaff")
    public ResponseEntity<List<String>> getStaffs(){
        List<String> allStaff = Arrays.asList("Madhav","Radha");
        return new ResponseEntity<>(allStaff, HttpStatus.OK);
    }

}
