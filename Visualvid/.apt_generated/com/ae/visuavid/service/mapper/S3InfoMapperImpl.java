package com.ae.visuavid.service.mapper;

import com.ae.visuavid.domain.S3InfoEntity;
import com.ae.visuavid.service.dto.S3InfoDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-29T20:33:57+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.14.0.v20180508-1005, environment: Java 1.8.0_281 (Oracle Corporation)"
)
@Component
public class S3InfoMapperImpl implements S3InfoMapper {

    @Override
    public S3InfoEntity toEntity(S3InfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        S3InfoEntity s3InfoEntity = new S3InfoEntity();

        s3InfoEntity.setId( dto.getId() );
        s3InfoEntity.setName( dto.getName() );
        s3InfoEntity.setS3Key( dto.getS3Key() );
        s3InfoEntity.setUrl( dto.getUrl() );
        s3InfoEntity.setStatus( dto.getStatus() );
        s3InfoEntity.setSize( dto.getSize() );

        return s3InfoEntity;
    }

    @Override
    public S3InfoDTO toDto(S3InfoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        S3InfoDTO s3InfoDTO = new S3InfoDTO();

        s3InfoDTO.setId( entity.getId() );
        s3InfoDTO.setName( entity.getName() );
        s3InfoDTO.setS3Key( entity.getS3Key() );
        s3InfoDTO.setUrl( entity.getUrl() );
        s3InfoDTO.setStatus( entity.getStatus() );
        s3InfoDTO.setSize( entity.getSize() );

        return s3InfoDTO;
    }
}
