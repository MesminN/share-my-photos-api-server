package com.tse.archintiers.photosharing.model.entity.PKs;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPhotoPK implements Serializable {
    private Long userId;

    private Long photoId;
}
