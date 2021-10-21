package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.MediaSlideEntity;
import com.ae.visuavid.domain.SlideItemEntity;
import com.ae.visuavid.service.dto.MediaSlideDTO;
import com.ae.visuavid.service.dto.OrderSlideDTO;
import com.ae.visuavid.service.dto.OrderSlideItemDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:59+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class MediaSlideMapperImpl implements MediaSlideMapper {

    @Autowired
    private SlideItemMapper slideItemMapper;

    @Override
    public MediaSlideEntity toEntity(MediaSlideDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MediaSlideEntity mediaSlideEntity = new MediaSlideEntity();

        mediaSlideEntity.setId( dto.getId() );
        mediaSlideEntity.setScreenShotS3Url( dto.getScreenShotS3Url() );
        mediaSlideEntity.setSlideItems( slideItemMapper.toEntities( dto.getSlideItems() ) );
        mediaSlideEntity.setScreenShotS3Key( dto.getScreenShotS3Key() );
        mediaSlideEntity.setSlideName( dto.getSlideName() );
        mediaSlideEntity.setSlideOrder( dto.getSlideOrder() );

        return mediaSlideEntity;
    }

    @Override
    public MediaSlideDTO toDto(MediaSlideEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MediaSlideDTO mediaSlideDTO = new MediaSlideDTO();

        mediaSlideDTO.setId( entity.getId() );
        mediaSlideDTO.setScreenShotS3Url( entity.getScreenShotS3Url() );
        mediaSlideDTO.setSlideItems( slideItemMapper.toDtos( entity.getSlideItems() ) );
        mediaSlideDTO.setScreenShotS3Key( entity.getScreenShotS3Key() );
        mediaSlideDTO.setSlideName( entity.getSlideName() );
        mediaSlideDTO.setSlideOrder( entity.getSlideOrder() );

        return mediaSlideDTO;
    }

    @Override
    public OrderSlideDTO toOrderSlideDto(MediaSlideEntity mediaSlideEntity) {
        if ( mediaSlideEntity == null ) {
            return null;
        }

        OrderSlideDTO orderSlideDTO = new OrderSlideDTO();

        orderSlideDTO.setAdminSlideId( mediaSlideEntity.getId() );
        orderSlideDTO.setOrderSlideItems( slideItemEntityListToOrderSlideItemDTOList( mediaSlideEntity.getSlideItems() ) );
        orderSlideDTO.setScreenShotS3Url( mediaSlideEntity.getScreenShotS3Url() );
        orderSlideDTO.setScreenShotS3Key( mediaSlideEntity.getScreenShotS3Key() );
        orderSlideDTO.setSlideName( mediaSlideEntity.getSlideName() );
        orderSlideDTO.setSlideOrder( mediaSlideEntity.getSlideOrder() );

        return orderSlideDTO;
    }

    protected List<OrderSlideItemDTO> slideItemEntityListToOrderSlideItemDTOList(List<SlideItemEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderSlideItemDTO> list1 = new ArrayList<OrderSlideItemDTO>( list.size() );
        for ( SlideItemEntity slideItemEntity : list ) {
            list1.add( slideItemMapper.toOrderSlideDto( slideItemEntity ) );
        }

        return list1;
    }
}
