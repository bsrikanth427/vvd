package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.UserSubscriptionEntity;
import com.ae.visuavid.service.dto.UserSubscriptionDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:59+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class UserSubscriptionMapperImpl implements UserSubscriptionMapper {

    @Override
    public UserSubscriptionEntity toEntity(UserSubscriptionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UserSubscriptionEntity userSubscriptionEntity = new UserSubscriptionEntity();

        userSubscriptionEntity.setId( dto.getId() );
        userSubscriptionEntity.setDiscountAmount( dto.getDiscountAmount() );
        userSubscriptionEntity.setStartDate( dto.getStartDate() );
        userSubscriptionEntity.setEndDate( dto.getEndDate() );
        userSubscriptionEntity.setRazorPayOrderId( dto.getRazorPayOrderId() );
        userSubscriptionEntity.setCurrencyCode( dto.getCurrencyCode() );
        userSubscriptionEntity.setOrderCount( dto.getOrderCount() );
        userSubscriptionEntity.setAvailedOrders( dto.getAvailedOrders() );
        userSubscriptionEntity.setStatus( dto.getStatus() );
        userSubscriptionEntity.setTotalAmount( dto.getTotalAmount() );
        userSubscriptionEntity.setCategoryId( dto.getCategoryId() );
        userSubscriptionEntity.setUserName( dto.getUserName() );
        userSubscriptionEntity.setPlanName( dto.getPlanName() );
        userSubscriptionEntity.setRazorPayKey( dto.getRazorPayKey() );

        return userSubscriptionEntity;
    }

    @Override
    public UserSubscriptionDTO toDto(UserSubscriptionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserSubscriptionDTO userSubscriptionDTO = new UserSubscriptionDTO();

        userSubscriptionDTO.setId( entity.getId() );
        userSubscriptionDTO.setDiscountAmount( entity.getDiscountAmount() );
        userSubscriptionDTO.setStartDate( entity.getStartDate() );
        userSubscriptionDTO.setEndDate( entity.getEndDate() );
        userSubscriptionDTO.setCurrencyCode( entity.getCurrencyCode() );
        userSubscriptionDTO.setCategoryId( entity.getCategoryId() );
        userSubscriptionDTO.setUserName( entity.getUserName() );
        userSubscriptionDTO.setStatus( entity.getStatus() );
        userSubscriptionDTO.setOrderCount( entity.getOrderCount() );
        userSubscriptionDTO.setAvailedOrders( entity.getAvailedOrders() );
        userSubscriptionDTO.setPlanName( entity.getPlanName() );
        userSubscriptionDTO.setTotalAmount( entity.getTotalAmount() );
        userSubscriptionDTO.setRazorPayKey( entity.getRazorPayKey() );
        userSubscriptionDTO.setRazorPayOrderId( entity.getRazorPayOrderId() );

        return userSubscriptionDTO;
    }
}
