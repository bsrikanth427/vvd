package com.ae.visuavid.service.dto;

import java.util.List;
import java.util.UUID;

public class OrderRequestDTO {
    private UUID userId;
    private String couponCode;
    private String currencyCode;
    private List<ItemCustomizationDTO> itemCustomizations;

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public List<ItemCustomizationDTO> getItemCustomizations() {
        return itemCustomizations;
    }

    public void setItemCustomizations(List<ItemCustomizationDTO> itemCustomizations) {
        this.itemCustomizations = itemCustomizations;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
