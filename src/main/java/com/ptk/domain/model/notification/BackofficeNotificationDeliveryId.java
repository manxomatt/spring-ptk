package com.ptk.domain.model.notification;

import lombok.*;

import java.io.Serializable;

/**
 * Composite key for BackofficeNotificationDelivery entity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BackofficeNotificationDeliveryId implements Serializable {
    private String notificationId;
    private String userId;
}
