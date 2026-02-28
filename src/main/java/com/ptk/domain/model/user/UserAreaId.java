package com.ptk.domain.model.user;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite key for UserArea entity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAreaId implements Serializable {

    private String userId;
    private String areaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAreaId that = (UserAreaId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(areaId, that.areaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, areaId);
    }
}
