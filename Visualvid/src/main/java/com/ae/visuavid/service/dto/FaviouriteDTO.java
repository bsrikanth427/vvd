package com.ae.visuavid.service.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;

public class FaviouriteDTO {
    @NotNull
    private UUID id;

    @NotNull
    private UUID mediaId;

    @NotNull
    private String slideName;

    @NotNull
    private UUID userId;

    @NotNull
    private String email;

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

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getSlideName() {
        return slideName;
    }

    public void setSlideName(String slideName) {
        this.slideName = slideName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
