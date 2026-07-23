package com.scaler.product.controller.fakestore_controller;

import com.scaler.product.dto.falestore_dto.FakeStoreLoginRequestDto;
import com.scaler.product.services.fakestore_services_impl.IFakeStoreAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class FakeStoreAuthController {

    @Autowired
    private IFakeStoreAuthService fakeStoreAuthService;


    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody FakeStoreLoginRequestDto requestDto) {
        MultiValueMap<String, String> headers = this.fakeStoreAuthService.login(requestDto);
        if (headers == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login failed");
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<String>("login successful", headers, HttpStatus.OK);
    }
}
