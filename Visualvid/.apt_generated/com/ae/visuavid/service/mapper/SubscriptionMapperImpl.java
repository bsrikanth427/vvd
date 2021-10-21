package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.SubscriptionEntity;
import com.ae.visuavid.service.dto.SubscriptionDTO;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:59+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class SubscriptionMapperImpl implements SubscriptionMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public SubscriptionEntity toEntity(SubscriptionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();

        subscriptionEntity.setId( dto.getId() );
        subscriptionEntity.setName( dto.getName() );
        subscriptionEntity.setType( dto.getType() );
        subscriptionEntity.setMonthlyPriceLocal( dto.getMonthlyPriceLocal() );
        subscriptionEntity.setYearlyPriceLocal( dto.getYearlyPriceLocal() );
        subscriptionEntity.setMonthlyPriceUsd( dto.getMonthlyPriceUsd() );
        subscriptionEntity.setYearlyPriceUsd( dto.getYearlyPriceUsd() );
        subscriptionEntity.setDiscountAmount( dto.getDiscountAmount() );
        subscriptionEntity.setDiscountPercentage( dto.getDiscountPercentage() );
        subscriptionEntity.setDownloads( dto.getDownloads() );
        subscriptionEntity.setDownloadPerDay( dto.getDownloadPerDay() );
        subscriptionEntity.setTextLine01( dto.getTextLine01() );
        subscriptionEntity.setTextLine02( dto.getTextLine02() );
        subscriptionEntity.setTextLine03( dto.getTextLine03() );
        subscriptionEntity.setTextLine04( dto.getTextLine04() );
        subscriptionEntity.setCategories( categoryMapper.toEntities( dto.getCategories() ) );
        subscriptionEntity.setUnLimitedDownloadsEnable( dto.getUnLimitedDownloadsEnable() );
        subscriptionEntity.setStatus( dto.getStatus() );

        return subscriptionEntity;
    }

    @Override
    public SubscriptionDTO toDto(SubscriptionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();

        subscriptionDTO.setId( entity.getId() );
        subscriptionDTO.setName( entity.getName() );
        subscriptionDTO.setType( entity.getType() );
        subscriptionDTO.setMonthlyPriceLocal( entity.getMonthlyPriceLocal() );
        subscriptionDTO.setYearlyPriceLocal( entity.getYearlyPriceLocal() );
        subscriptionDTO.setMonthlyPriceUsd( entity.getMonthlyPriceUsd() );
        subscriptionDTO.setYearlyPriceUsd( entity.getYearlyPriceUsd() );
        subscriptionDTO.setDiscountAmount( entity.getDiscountAmount() );
        subscriptionDTO.setDiscountPercentage( entity.getDiscountPercentage() );
        subscriptionDTO.setDownloads( entity.getDownloads() );
        subscriptionDTO.setDownloadPerDay( entity.getDownloadPerDay() );
        subscriptionDTO.setUnLimitedDownloadsEnable( entity.getUnLimitedDownloadsEnable() );
        subscriptionDTO.setTextLine01( entity.getTextLine01() );
        subscriptionDTO.setTextLine02( entity.getTextLine02() );
        subscriptionDTO.setTextLine03( entity.getTextLine03() );
        subscriptionDTO.setTextLine04( entity.getTextLine04() );
        subscriptionDTO.setCategories( categoryMapper.toDtos( entity.getCategories() ) );
        subscriptionDTO.setStatus( entity.getStatus() );

        return subscriptionDTO;
    }
}
