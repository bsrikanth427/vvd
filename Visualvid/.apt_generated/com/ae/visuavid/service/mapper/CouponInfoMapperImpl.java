package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.CouponInfoEntity;
import com.ae.visuavid.service.dto.CouponInfoDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:59+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class CouponInfoMapperImpl implements CouponInfoMapper {

    @Override
    public CouponInfoEntity toEntity(CouponInfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CouponInfoEntity couponInfoEntity = new CouponInfoEntity();

        couponInfoEntity.setId( dto.getId() );
        couponInfoEntity.setStartDate( dto.getStartDate() );
        couponInfoEntity.setEndDate( dto.getEndDate() );
        couponInfoEntity.setDescription( dto.getDescription() );
        couponInfoEntity.setActive( dto.isActive() );
        couponInfoEntity.setCouponDiscountAmount( dto.getCouponDiscountAmount() );
        couponInfoEntity.setCouponDiscountPercentage( dto.getCouponDiscountPercentage() );
        couponInfoEntity.setCouponCode( dto.getCouponCode() );

        return couponInfoEntity;
    }

    @Override
    public CouponInfoDTO toDto(CouponInfoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CouponInfoDTO couponInfoDTO = new CouponInfoDTO();

        couponInfoDTO.setId( entity.getId() );
        couponInfoDTO.setStartDate( entity.getStartDate() );
        couponInfoDTO.setEndDate( entity.getEndDate() );
        couponInfoDTO.setDescription( entity.getDescription() );
        couponInfoDTO.setActive( entity.isActive() );
        couponInfoDTO.setCouponDiscountAmount( entity.getCouponDiscountAmount() );
        couponInfoDTO.setCouponDiscountPercentage( entity.getCouponDiscountPercentage() );
        couponInfoDTO.setCouponCode( entity.getCouponCode() );

        return couponInfoDTO;
    }
}
