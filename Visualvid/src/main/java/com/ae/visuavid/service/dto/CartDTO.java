package com.ae.visuavid.service.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;

public class CartDTO implements BaseDTO {
    @NotNull
    private UUID id;

    @NotNull
    private UUID mediaId;

    @NotNull
    private String mediaName;

    @NotNull
    private UUID userId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMediaId() {
        return mediaId;
    }

    public void setMediaId(UUID mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
