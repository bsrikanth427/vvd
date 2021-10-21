package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.SlideItemEntity;
import com.ae.visuavid.service.dto.OrderSlideItemDTO;
import com.ae.visuavid.service.dto.SlideItemDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:58+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class SlideItemMapperImpl implements SlideItemMapper {

    @Override
    public SlideItemEntity toEntity(SlideItemDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SlideItemEntity slideItemEntity = new SlideItemEntity();

        slideItemEntity.setId( dto.getId() );
        slideItemEntity.setType( dto.getType() );
        slideItemEntity.setLabel( dto.getLabel() );
        slideItemEntity.setOrder( dto.getOrder() );

        return slideItemEntity;
    }

    @Override
    public SlideItemDTO toDto(SlideItemEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SlideItemDTO slideItemDTO = new SlideItemDTO();

        slideItemDTO.setId( entity.getId() );
        slideItemDTO.setType( entity.getType() );
        slideItemDTO.setLabel( entity.getLabel() );
        slideItemDTO.setOrder( entity.getOrder() );

        return slideItemDTO;
    }

    @Override
    public OrderSlideItemDTO toOrderSlideDto(SlideItemEntity slideItemEntity) {
        if ( slideItemEntity == null ) {
            return null;
        }

        OrderSlideItemDTO orderSlideItemDTO = new OrderSlideItemDTO();

        orderSlideItemDTO.setItemType( slideItemEntity.getType() );
        orderSlideItemDTO.setItemOrder( slideItemEntity.getOrder() );
        orderSlideItemDTO.setItemLabel( slideItemEntity.getLabel() );
        orderSlideItemDTO.setAdminSlideItemId( slideItemEntity.getId() );

        return orderSlideItemDTO;
    }
}
