package com.tse.archintiers.photosharing.model.dto.payload.response;

import com.tse.archintiers.photosharing.model.dto.User;
import com.tse.archintiers.photosharing.model.dto.payload.JwtToken;
import lombok.Getter;

@Getter
public class JwtResponse {
    private final JwtToken token;
    private final User user;

	public JwtResponse(JwtToken accessToken, User user) {
		this.token = accessToken;
		this.user = user;
	}
}
