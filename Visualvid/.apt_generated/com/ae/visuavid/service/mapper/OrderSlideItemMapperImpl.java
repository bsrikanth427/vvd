package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.OrderSlideItemEntity;
import com.ae.visuavid.service.dto.OrderSlideItemDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:59+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class OrderSlideItemMapperImpl implements OrderSlideItemMapper {

    @Override
    public OrderSlideItemEntity toEntity(OrderSlideItemDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OrderSlideItemEntity orderSlideItemEntity = new OrderSlideItemEntity();

        orderSlideItemEntity.setId( dto.getId() );
        orderSlideItemEntity.setItemType( dto.getItemType() );
        orderSlideItemEntity.setItemLabel( dto.getItemLabel() );
        orderSlideItemEntity.setItemOrder( dto.getItemOrder() );
        orderSlideItemEntity.setS3Url( dto.getS3Url() );
        orderSlideItemEntity.setS3Key( dto.getS3Key() );
        orderSlideItemEntity.setItemValue( dto.getItemValue() );
        orderSlideItemEntity.setAdminSlideItemId( dto.getAdminSlideItemId() );

        return orderSlideItemEntity;
    }

    @Override
    public OrderSlideItemDTO toDto(OrderSlideItemEntity entity) {
        if ( entity == null ) {
            return null;
        }

        OrderSlideItemDTO orderSlideItemDTO = new OrderSlideItemDTO();

        orderSlideItemDTO.setItemType( entity.getItemType() );
        orderSlideItemDTO.setItemLabel( entity.getItemLabel() );
        orderSlideItemDTO.setItemValue( entity.getItemValue() );
        orderSlideItemDTO.setItemOrder( entity.getItemOrder() );
        orderSlideItemDTO.setS3Url( entity.getS3Url() );
        orderSlideItemDTO.setS3Key( entity.getS3Key() );
        orderSlideItemDTO.setAdminSlideItemId( entity.getAdminSlideItemId() );
        orderSlideItemDTO.setId( entity.getId() );

        return orderSlideItemDTO;
    }
}
