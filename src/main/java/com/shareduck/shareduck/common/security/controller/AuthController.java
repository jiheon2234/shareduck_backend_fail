package com.shareduck.shareduck.common.security.controller;

import com.shareduck.shareduck.common.security.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "AUTH",description = "Security 관련 API")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/reissue")
    public ResponseEntity<Void> reissue(HttpServletRequest request, HttpServletResponse response) {
        service.reissue(request, response);
        return ResponseEntity.noContent().build();
    }
}
