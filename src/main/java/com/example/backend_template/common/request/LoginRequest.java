package com.example.backend_template.common.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;

}
