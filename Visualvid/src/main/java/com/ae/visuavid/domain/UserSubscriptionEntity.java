package com.ae.visuavid.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_subscription")
public class UserSubscriptionEntity extends AbstractAuditingEntity implements BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Column(name = "basic_amount")
    private BigDecimal basicAmount;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "order_count")
    private Integer orderCount;

    @Column(name = "availed_orders")
    private Integer availedOrders;

    @Column(name = "status")
    private String status;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @Column(name = "latest_download_time")
    private Instant latestDownloadTime;

    @Column(name = "unlimited_download_enable")
    private Boolean unLimitedDownloadsEnable;

    // Pricing info
    @Column(name = "razor_pay_order_id")
    private String razorPayOrderId;

    @Column(name = "razor_pay_payment_id")
    private String razorPayPaymentId;

    @Column(name = "razor_pay_key")
    private String razorPayKey;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "payment_order_id")
    private String paymentOrderId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "plan_name")
    private String planName;

    @OneToOne
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private SubscriptionEntity subscription;

    @OneToMany(mappedBy = "userSubscription", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private List<UserSubscriptionDownloadEntity> userSubscriptionDownloads;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubscriptionEntity getSubscription() {
        return subscription;
    }

    public void setSubscription(SubscriptionEntity subscription) {
        this.subscription = subscription;
    }

    public String getRazorPayOrderId() {
        return razorPayOrderId;
    }

    public void setRazorPayOrderId(String razorPayOrderId) {
        this.razorPayOrderId = razorPayOrderId;
    }

    public String getRazorPayPaymentId() {
        return razorPayPaymentId;
    }

    public void setRazorPayPaymentId(String razorPayPaymentId) {
        this.razorPayPaymentId = razorPayPaymentId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getAvailedOrders() {
        return availedOrders;
    }

    public void setAvailedOrders(Integer availedOrders) {
        this.availedOrders = availedOrders;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBasicAmount() {
        return basicAmount;
    }

    public void setBasicAmount(BigDecimal basicAmount) {
        this.basicAmount = basicAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Instant getLatestDownloadTime() {
        return latestDownloadTime;
    }

    public void setLatestDownloadTime(Instant latestDownloadTime) {
        this.latestDownloadTime = latestDownloadTime;
    }

    public Boolean getUnLimitedDownloadsEnable() {
        return unLimitedDownloadsEnable;
    }

    public void setUnLimitedDownloadsEnable(Boolean unLimitedDownloadsEnable) {
        this.unLimitedDownloadsEnable = unLimitedDownloadsEnable;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserSubscriptionDownloadEntity> getUserSubscriptionDownloads() {
        return userSubscriptionDownloads;
    }

    public void setUserSubscriptionDownloads(List<UserSubscriptionDownloadEntity> userSubscriptionDownloads) {
        this.userSubscriptionDownloads = userSubscriptionDownloads;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getRazorPayKey() {
        return razorPayKey;
    }

    public void setRazorPayKey(String razorPayKey) {
        this.razorPayKey = razorPayKey;
    }
}
