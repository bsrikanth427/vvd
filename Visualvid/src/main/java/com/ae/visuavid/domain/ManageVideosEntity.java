package com.ae.visuavid.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "manage_videos")
public class ManageVideosEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String userId;

    @Column
    private String mailId;

    @Column
    private String agentId;

    @Column
    private Date date;

    @Column
    private String fileName;

    @Column
    private String fileType;

    @Column
    @Lob
    private byte[] data;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private String categoryId;

    @NotNull
    private String subCategoryId;

    private String subCategoryName;
    private String categoryName;

    @NotNull
    private BigDecimal indianPrice;

    @NotNull
    private BigDecimal indianDiscPrice;

    @NotNull
    private BigDecimal indianAdvCustomizationPrice;

    @NotNull
    private BigDecimal indianPremumDeliveryPrice;

    @NotNull
    private BigDecimal usdDiscPrice;

    @NotNull
    private BigDecimal usdAdvCustomizationPrice;

    @NotNull
    private BigDecimal usdPremumDeliveryPrice;

    @NotNull
    private BigDecimal usdPrice;

    @Column
    private String previewVideoS3Url;

    @Column
    private String previewVideoS3Key;

    @Column
    private String thumbNailS3Url;

    @Column
    private String thumbNailS3Key;

    @Column
    private String mediaPlaceholder;

    @Column
    private String textPlaceholder;

    @Column
    private String turnAroundTime;

    @Column
    private Integer templateCount;

    @Column
    private Double earnings;

    @Column
    private String tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getIndianPrice() {
        return indianPrice;
    }

    public void setIndianPrice(BigDecimal indianPrice) {
        this.indianPrice = indianPrice;
    }

    public BigDecimal getIndianDiscPrice() {
        return indianDiscPrice;
    }

    public void setIndianDiscPrice(BigDecimal indianDiscPrice) {
        this.indianDiscPrice = indianDiscPrice;
    }

    public BigDecimal getIndianAdvCustomizationPrice() {
        return indianAdvCustomizationPrice;
    }

    public void setIndianAdvCustomizationPrice(BigDecimal indianAdvCustomizationPrice) {
        this.indianAdvCustomizationPrice = indianAdvCustomizationPrice;
    }

    public BigDecimal getIndianPremumDeliveryPrice() {
        return indianPremumDeliveryPrice;
    }

    public void setIndianPremumDeliveryPrice(BigDecimal indianPremumDeliveryPrice) {
        this.indianPremumDeliveryPrice = indianPremumDeliveryPrice;
    }

    public BigDecimal getUsdDiscPrice() {
        return usdDiscPrice;
    }

    public void setUsdDiscPrice(BigDecimal usdDiscPrice) {
        this.usdDiscPrice = usdDiscPrice;
    }

    public BigDecimal getUsdAdvCustomizationPrice() {
        return usdAdvCustomizationPrice;
    }

    public void setUsdAdvCustomizationPrice(BigDecimal usdAdvCustomizationPrice) {
        this.usdAdvCustomizationPrice = usdAdvCustomizationPrice;
    }

    public BigDecimal getUsdPremumDeliveryPrice() {
        return usdPremumDeliveryPrice;
    }

    public void setUsdPremumDeliveryPrice(BigDecimal usdPremumDeliveryPrice) {
        this.usdPremumDeliveryPrice = usdPremumDeliveryPrice;
    }

    public BigDecimal getUsdPrice() {
        return usdPrice;
    }

    public void setUsdPrice(BigDecimal usdPrice) {
        this.usdPrice = usdPrice;
    }

    public String getPreviewVideoS3Url() {
        return previewVideoS3Url;
    }

    public void setPreviewVideoS3Url(String previewVideoS3Url) {
        this.previewVideoS3Url = previewVideoS3Url;
    }

    public String getPreviewVideoS3Key() {
        return previewVideoS3Key;
    }

    public void setPreviewVideoS3Key(String previewVideoS3Key) {
        this.previewVideoS3Key = previewVideoS3Key;
    }

    public String getThumbNailS3Url() {
        return thumbNailS3Url;
    }

    public void setThumbNailS3Url(String thumbNailS3Url) {
        this.thumbNailS3Url = thumbNailS3Url;
    }

    public String getThumbNailS3Key() {
        return thumbNailS3Key;
    }

    public void setThumbNailS3Key(String thumbNailS3Key) {
        this.thumbNailS3Key = thumbNailS3Key;
    }

    public String getMediaPlaceholder() {
        return mediaPlaceholder;
    }

    public void setMediaPlaceholder(String mediaPlaceholder) {
        this.mediaPlaceholder = mediaPlaceholder;
    }

    public String getTextPlaceholder() {
        return textPlaceholder;
    }

    public void setTextPlaceholder(String textPlaceholder) {
        this.textPlaceholder = textPlaceholder;
    }

    public String getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(String turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public Integer getTemplateCount() {
        return templateCount;
    }

    public void setTemplateCount(Integer templateCount) {
        this.templateCount = templateCount;
    }

    public Double getEarnings() {
        return earnings;
    }

    public void setEarnings(Double earnings) {
        this.earnings = earnings;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
