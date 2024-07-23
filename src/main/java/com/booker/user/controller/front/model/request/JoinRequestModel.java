package com.booker.user.controller.front.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequestModel {

    @NotBlank
    private String id;

    @NotBlank
    private String password;

    @NotBlank
    private String nickname;

    @NotBlank
    @Email
    private String email;

}
