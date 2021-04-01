package com.hhblog.hanghae.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String passwordNen;
    private String passwordConfirm;
//    private boolean admin = false;
//    private String adminToken = "";
}