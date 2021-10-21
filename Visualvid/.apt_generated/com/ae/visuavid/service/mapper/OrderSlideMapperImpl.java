package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.OrderSlideEntity;
import com.ae.visuavid.service.dto.OrderSlideDTO;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:58+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class OrderSlideMapperImpl extends OrderSlideMapper {

    @Autowired
    private OrderSlideItemMapper orderSlideItemMapper;

    @Override
    public OrderSlideEntity toEntity(OrderSlideDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OrderSlideEntity orderSlideEntity = new OrderSlideEntity();

        orderSlideEntity.setId( dto.getId() );
        orderSlideEntity.setScreenShotS3Url( dto.getScreenShotS3Url() );
        orderSlideEntity.setScreenShotS3Key( dto.getScreenShotS3Key() );
        orderSlideEntity.setSlideName( dto.getSlideName() );
        orderSlideEntity.setSlideOrder( dto.getSlideOrder() );
        orderSlideEntity.setAdminSlideId( dto.getAdminSlideId() );
        orderSlideEntity.setOrderSlideItems( orderSlideItemMapper.toEntities( dto.getOrderSlideItems() ) );

        return orderSlideEntity;
    }

    @Override
    public OrderSlideDTO toDto(OrderSlideEntity entity) {
        if ( entity == null ) {
            return null;
        }

        OrderSlideDTO orderSlideDTO = new OrderSlideDTO();

        orderSlideDTO.setId( entity.getId() );
        orderSlideDTO.setScreenShotS3Url( entity.getScreenShotS3Url() );
        orderSlideDTO.setScreenShotS3Key( entity.getScreenShotS3Key() );
        orderSlideDTO.setSlideName( entity.getSlideName() );
        orderSlideDTO.setSlideOrder( entity.getSlideOrder() );
        orderSlideDTO.setAdminSlideId( entity.getAdminSlideId() );
        orderSlideDTO.setOrderSlideItems( orderSlideItemMapper.toDtos( entity.getOrderSlideItems() ) );

        return orderSlideDTO;
    }
}
