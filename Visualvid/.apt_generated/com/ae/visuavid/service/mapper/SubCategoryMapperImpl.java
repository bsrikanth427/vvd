package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.SubCategoryEntity;
import com.ae.visuavid.service.dto.SubCategoryDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:59+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class SubCategoryMapperImpl implements SubCategoryMapper {

    @Override
    public SubCategoryEntity toEntity(SubCategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();

        subCategoryEntity.setId( dto.getId() );
        subCategoryEntity.setName( dto.getName() );

        return subCategoryEntity;
    }

    @Override
    public SubCategoryDTO toDto(SubCategoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();

        subCategoryDTO.setId( entity.getId() );
        subCategoryDTO.setName( entity.getName() );

        return subCategoryDTO;
    }
}
