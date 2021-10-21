package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.OrderEntity;
import com.ae.visuavid.service.dto.OrderDTO;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:59+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private OrderSlideMapper orderSlideMapper;

    @Override
    public OrderEntity toEntity(OrderDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( dto.getId() );
        orderEntity.setOrderId( dto.getOrderId() );
        orderEntity.setSalesId( dto.getSalesId() );
        orderEntity.setOrderStatus( dto.getOrderStatus() );
        orderEntity.setAdminMediaId( dto.getAdminMediaId() );
        orderEntity.setAssignedUserId( dto.getAssignedUserId() );
        orderEntity.setAssignedUserName( dto.getAssignedUserName() );
        orderEntity.setName( dto.getName() );
        orderEntity.setDescription( dto.getDescription() );
        orderEntity.setCategoryId( dto.getCategoryId() );
        orderEntity.setCategoryName( dto.getCategoryName() );
        orderEntity.setPreviewVideoS3Url( dto.getPreviewVideoS3Url() );
        orderEntity.setPreviewVideoS3Key( dto.getPreviewVideoS3Key() );
        orderEntity.setThumbNailS3Url( dto.getThumbNailS3Url() );
        orderEntity.setThumbNailS3Key( dto.getThumbNailS3Key() );
        orderEntity.setMediaPlaceholder( dto.getMediaPlaceholder() );
        orderEntity.setTextPlaceholder( dto.getTextPlaceholder() );
        orderEntity.setTurnAroundTime( dto.getTurnAroundTime() );
        orderEntity.setTags( dto.getTags() );
        orderEntity.setRazorPayOrderId( dto.getRazorPayOrderId() );
        orderEntity.setRazorPayPaymentId( dto.getRazorPayPaymentId() );
        orderEntity.setCurrencyCode( dto.getCurrencyCode() );
        orderEntity.setBasicAmount( dto.getBasicAmount() );
        orderEntity.setDiscountAmount( dto.getDiscountAmount() );
        orderEntity.setAdvancedCustomizationAmount( dto.getAdvancedCustomizationAmount() );
        orderEntity.setPremiumDeliveryAmount( dto.getPremiumDeliveryAmount() );
        orderEntity.setGstAmount( dto.getGstAmount() );
        orderEntity.setTotalAmount( dto.getTotalAmount() );
        orderEntity.setOrderSlides( orderSlideMapper.toEntities( dto.getOrderSlides() ) );
        orderEntity.setCouponCode( dto.getCouponCode() );
        orderEntity.setCouponDiscountAmount( dto.getCouponDiscountAmount() );
        orderEntity.setCouponDiscountPercentage( dto.getCouponDiscountPercentage() );
        orderEntity.setGstPercentage( dto.getGstPercentage() );
        orderEntity.setPaymentOrderId( dto.getPaymentOrderId() );
        orderEntity.setUserId( dto.getUserId() );
        orderEntity.setSubCategoryId( dto.getSubCategoryId() );
        orderEntity.setSubCategoryName( dto.getSubCategoryName() );

        return orderEntity;
    }

    @Override
    public OrderDTO toDto(OrderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( entity.getId() );
        orderDTO.setOrderId( entity.getOrderId() );
        orderDTO.setSalesId( entity.getSalesId() );
        orderDTO.setOrderStatus( entity.getOrderStatus() );
        orderDTO.setAdminMediaId( entity.getAdminMediaId() );
        orderDTO.setAssignedUserId( entity.getAssignedUserId() );
        orderDTO.setAssignedUserName( entity.getAssignedUserName() );
        orderDTO.setName( entity.getName() );
        orderDTO.setDescription( entity.getDescription() );
        orderDTO.setCategoryId( entity.getCategoryId() );
        orderDTO.setSubCategoryId( entity.getSubCategoryId() );
        orderDTO.setSubCategoryName( entity.getSubCategoryName() );
        orderDTO.setCategoryName( entity.getCategoryName() );
        orderDTO.setPreviewVideoS3Url( entity.getPreviewVideoS3Url() );
        orderDTO.setPreviewVideoS3Key( entity.getPreviewVideoS3Key() );
        orderDTO.setThumbNailS3Url( entity.getThumbNailS3Url() );
        orderDTO.setThumbNailS3Key( entity.getThumbNailS3Key() );
        orderDTO.setMediaPlaceholder( entity.getMediaPlaceholder() );
        orderDTO.setTextPlaceholder( entity.getTextPlaceholder() );
        orderDTO.setTurnAroundTime( entity.getTurnAroundTime() );
        orderDTO.setTags( entity.getTags() );
        orderDTO.setRazorPayOrderId( entity.getRazorPayOrderId() );
        orderDTO.setRazorPayPaymentId( entity.getRazorPayPaymentId() );
        orderDTO.setCurrencyCode( entity.getCurrencyCode() );
        orderDTO.setBasicAmount( entity.getBasicAmount() );
        orderDTO.setDiscountAmount( entity.getDiscountAmount() );
        orderDTO.setAdvancedCustomizationAmount( entity.getAdvancedCustomizationAmount() );
        orderDTO.setPremiumDeliveryAmount( entity.getPremiumDeliveryAmount() );
        orderDTO.setGstAmount( entity.getGstAmount() );
        orderDTO.setTotalAmount( entity.getTotalAmount() );
        orderDTO.setOrderSlides( orderSlideMapper.toDtos( entity.getOrderSlides() ) );
        orderDTO.setCouponDiscountAmount( entity.getCouponDiscountAmount() );
        orderDTO.setCouponDiscountPercentage( entity.getCouponDiscountPercentage() );
        orderDTO.setGstPercentage( entity.getGstPercentage() );
        orderDTO.setCouponCode( entity.getCouponCode() );
        orderDTO.setPaymentOrderId( entity.getPaymentOrderId() );
        orderDTO.setUserId( entity.getUserId() );

        return orderDTO;
    }
}
