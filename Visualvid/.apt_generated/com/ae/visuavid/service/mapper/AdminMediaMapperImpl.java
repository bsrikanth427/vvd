package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.AdminMediaEntity;
import com.ae.visuavid.domain.MediaTags;
import com.ae.visuavid.service.dto.AdminMediaDTO;
import com.ae.visuavid.service.dto.MediaTagsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:58+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class AdminMediaMapperImpl implements AdminMediaMapper {

    @Autowired
    private MediaSlideMapper mediaSlideMapper;

    @Override
    public AdminMediaEntity toEntity(AdminMediaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AdminMediaEntity adminMediaEntity = new AdminMediaEntity();

        adminMediaEntity.setId( dto.getId() );
        adminMediaEntity.setName( dto.getName() );
        adminMediaEntity.setDescription( dto.getDescription() );
        adminMediaEntity.setIndianPrice( dto.getIndianPrice() );
        adminMediaEntity.setUsdPrice( dto.getUsdPrice() );
        adminMediaEntity.setPreviewVideoS3Url( dto.getPreviewVideoS3Url() );
        adminMediaEntity.setThumbNailS3Url( dto.getThumbNailS3Url() );
        adminMediaEntity.setMediaPlaceholder( dto.getMediaPlaceholder() );
        adminMediaEntity.setTextPlaceholder( dto.getTextPlaceholder() );
        if ( dto.getTurnAroundTime() != null ) {
            adminMediaEntity.setTurnAroundTime( Long.parseLong( dto.getTurnAroundTime() ) );
        }
        adminMediaEntity.setSlides( mediaSlideMapper.toEntities( dto.getSlides() ) );
        adminMediaEntity.setCategoryId( dto.getCategoryId() );
        adminMediaEntity.setThumbNailS3Key( dto.getThumbNailS3Key() );
        adminMediaEntity.setPreviewVideoS3Key( dto.getPreviewVideoS3Key() );
        adminMediaEntity.setTemplateCount( dto.getTemplateCount() );
        adminMediaEntity.setEarnings( dto.getEarnings() );
        adminMediaEntity.setIndianDiscPrice( dto.getIndianDiscPrice() );
        adminMediaEntity.setIndianAdvCustomizationPrice( dto.getIndianAdvCustomizationPrice() );
        adminMediaEntity.setIndianPremumDeliveryPrice( dto.getIndianPremumDeliveryPrice() );
        adminMediaEntity.setUsdDiscPrice( dto.getUsdDiscPrice() );
        adminMediaEntity.setUsdAdvCustomizationPrice( dto.getUsdAdvCustomizationPrice() );
        adminMediaEntity.setUsdPremumDeliveryPrice( dto.getUsdPremumDeliveryPrice() );
        adminMediaEntity.setSubCategoryId( dto.getSubCategoryId() );
        adminMediaEntity.setTags( mediaTagsDTOListToMediaTagsList( dto.getTags() ) );

        return adminMediaEntity;
    }

    @Override
    public AdminMediaDTO toDto(AdminMediaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AdminMediaDTO adminMediaDTO = new AdminMediaDTO();

        adminMediaDTO.setName( entity.getName() );
        adminMediaDTO.setDescription( entity.getDescription() );
        adminMediaDTO.setIndianPrice( entity.getIndianPrice() );
        adminMediaDTO.setUsdPrice( entity.getUsdPrice() );
        adminMediaDTO.setPreviewVideoS3Url( entity.getPreviewVideoS3Url() );
        adminMediaDTO.setThumbNailS3Url( entity.getThumbNailS3Url() );
        adminMediaDTO.setMediaPlaceholder( entity.getMediaPlaceholder() );
        adminMediaDTO.setTextPlaceholder( entity.getTextPlaceholder() );
        if ( entity.getTurnAroundTime() != null ) {
            adminMediaDTO.setTurnAroundTime( String.valueOf( entity.getTurnAroundTime() ) );
        }
        adminMediaDTO.setTemplateCount( entity.getTemplateCount() );
        adminMediaDTO.setSlides( mediaSlideMapper.toDtos( entity.getSlides() ) );
        adminMediaDTO.setId( entity.getId() );
        adminMediaDTO.setCategoryId( entity.getCategoryId() );
        adminMediaDTO.setPreviewVideoS3Key( entity.getPreviewVideoS3Key() );
        adminMediaDTO.setThumbNailS3Key( entity.getThumbNailS3Key() );
        adminMediaDTO.setEarnings( entity.getEarnings() );
        adminMediaDTO.setIndianDiscPrice( entity.getIndianDiscPrice() );
        adminMediaDTO.setIndianAdvCustomizationPrice( entity.getIndianAdvCustomizationPrice() );
        adminMediaDTO.setIndianPremumDeliveryPrice( entity.getIndianPremumDeliveryPrice() );
        adminMediaDTO.setUsdDiscPrice( entity.getUsdDiscPrice() );
        adminMediaDTO.setUsdAdvCustomizationPrice( entity.getUsdAdvCustomizationPrice() );
        adminMediaDTO.setUsdPremumDeliveryPrice( entity.getUsdPremumDeliveryPrice() );
        adminMediaDTO.setSubCategoryId( entity.getSubCategoryId() );
        adminMediaDTO.setTags( mediaTagsListToMediaTagsDTOList( entity.getTags() ) );

        return adminMediaDTO;
    }

    @Override
    public AdminMediaDTO toDtoBasic(AdminMediaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AdminMediaDTO adminMediaDTO = new AdminMediaDTO();

        adminMediaDTO.setName( entity.getName() );
        adminMediaDTO.setDescription( entity.getDescription() );
        adminMediaDTO.setIndianPrice( entity.getIndianPrice() );
        adminMediaDTO.setUsdPrice( entity.getUsdPrice() );
        adminMediaDTO.setPreviewVideoS3Url( entity.getPreviewVideoS3Url() );
        adminMediaDTO.setThumbNailS3Url( entity.getThumbNailS3Url() );
        adminMediaDTO.setMediaPlaceholder( entity.getMediaPlaceholder() );
        adminMediaDTO.setTextPlaceholder( entity.getTextPlaceholder() );
        if ( entity.getTurnAroundTime() != null ) {
            adminMediaDTO.setTurnAroundTime( String.valueOf( entity.getTurnAroundTime() ) );
        }
        adminMediaDTO.setTemplateCount( entity.getTemplateCount() );
        adminMediaDTO.setId( entity.getId() );
        adminMediaDTO.setCategoryId( entity.getCategoryId() );
        adminMediaDTO.setPreviewVideoS3Key( entity.getPreviewVideoS3Key() );
        adminMediaDTO.setThumbNailS3Key( entity.getThumbNailS3Key() );
        adminMediaDTO.setEarnings( entity.getEarnings() );
        adminMediaDTO.setIndianDiscPrice( entity.getIndianDiscPrice() );
        adminMediaDTO.setIndianAdvCustomizationPrice( entity.getIndianAdvCustomizationPrice() );
        adminMediaDTO.setIndianPremumDeliveryPrice( entity.getIndianPremumDeliveryPrice() );
        adminMediaDTO.setUsdDiscPrice( entity.getUsdDiscPrice() );
        adminMediaDTO.setUsdAdvCustomizationPrice( entity.getUsdAdvCustomizationPrice() );
        adminMediaDTO.setUsdPremumDeliveryPrice( entity.getUsdPremumDeliveryPrice() );
        adminMediaDTO.setSubCategoryId( entity.getSubCategoryId() );
        adminMediaDTO.setTags( mediaTagsListToMediaTagsDTOList( entity.getTags() ) );

        return adminMediaDTO;
    }

    protected MediaTags mediaTagsDTOToMediaTags(MediaTagsDTO mediaTagsDTO) {
        if ( mediaTagsDTO == null ) {
            return null;
        }

        MediaTags mediaTags = new MediaTags();

        mediaTags.setId( mediaTagsDTO.getId() );
        mediaTags.setTag( mediaTagsDTO.getTag() );

        return mediaTags;
    }

    protected List<MediaTags> mediaTagsDTOListToMediaTagsList(List<MediaTagsDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<MediaTags> list1 = new ArrayList<MediaTags>( list.size() );
        for ( MediaTagsDTO mediaTagsDTO : list ) {
            list1.add( mediaTagsDTOToMediaTags( mediaTagsDTO ) );
        }

        return list1;
    }

    protected MediaTagsDTO mediaTagsToMediaTagsDTO(MediaTags mediaTags) {
        if ( mediaTags == null ) {
            return null;
        }

        MediaTagsDTO mediaTagsDTO = new MediaTagsDTO();

        mediaTagsDTO.setId( mediaTags.getId() );
        mediaTagsDTO.setTag( mediaTags.getTag() );

        return mediaTagsDTO;
    }

    protected List<MediaTagsDTO> mediaTagsListToMediaTagsDTOList(List<MediaTags> list) {
        if ( list == null ) {
            return null;
        }

        List<MediaTagsDTO> list1 = new ArrayList<MediaTagsDTO>( list.size() );
        for ( MediaTags mediaTags : list ) {
            list1.add( mediaTagsToMediaTagsDTO( mediaTags ) );
        }

        return list1;
    }
}
