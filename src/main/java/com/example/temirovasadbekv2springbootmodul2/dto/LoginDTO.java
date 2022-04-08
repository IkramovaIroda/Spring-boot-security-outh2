package com.example.temirovasadbekv2springbootmodul2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {

    private String userName;
    private String password;
}
