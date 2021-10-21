package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.CategoryEntity;
import com.ae.visuavid.service.dto.CategoryDTO;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:59+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @Override
    public CategoryEntity toEntity(CategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( dto.getId() );
        categoryEntity.setSubCategories( subCategoryMapper.toEntities( dto.getSubCategories() ) );
        categoryEntity.setName( dto.getName() );
        categoryEntity.setS3CoverImageKey( dto.getS3CoverImageKey() );
        categoryEntity.setS3CoverImageUrl( dto.getS3CoverImageUrl() );

        return categoryEntity;
    }

    @Override
    public CategoryDTO toDto(CategoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setName( entity.getName() );
        categoryDTO.setId( entity.getId() );
        categoryDTO.setSubCategories( subCategoryMapper.toDtos( entity.getSubCategories() ) );
        categoryDTO.setS3CoverImageKey( entity.getS3CoverImageKey() );
        categoryDTO.setS3CoverImageUrl( entity.getS3CoverImageUrl() );

        return categoryDTO;
    }
}
