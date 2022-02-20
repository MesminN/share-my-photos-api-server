package com.tse.archintiers.photosharing.model.dto.payload.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	@NotBlank
	private String email;

	@NotBlank
	private String password;
}
