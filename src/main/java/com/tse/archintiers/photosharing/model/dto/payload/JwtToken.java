package com.tse.archintiers.photosharing.model.dto.payload;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtToken {
    private String token;
    private String type = "Bearer";
    private Date expirationDate;

    public JwtToken(String token, Date expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
    }
}
