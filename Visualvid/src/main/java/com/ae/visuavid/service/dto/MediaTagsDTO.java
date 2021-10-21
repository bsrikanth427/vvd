package com.ae.visuavid.service.dto;

import java.util.UUID;

public class MediaTagsDTO implements BaseDTO {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private UUID id;

    private String tag;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
