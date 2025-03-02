package com.rolandsall.kafka.template.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TrackingId {
    private String id;

    public static TrackingId createTrackingId(String orderId) {
        return TrackingId.builder().id("TR_" + orderId.substring(0, 6)).build();
    }

}

