package com.ae.visuavid.repository;

import com.ae.visuavid.domain.AdminMediaEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUploadFormRepository extends JpaRepository<AdminMediaEntity, UUID> {
    List<AdminMediaEntity> findByCategoryId(String categoryId);

    AdminMediaEntity findByCategoryId(UUID categoryId);

    Page<AdminMediaEntity> findByCategoryId(Pageable pageable, String categoryId);

    Page<AdminMediaEntity> findByNameIgnoreCaseContaining(Pageable pageable, String mediaName);

    List<AdminMediaEntity> findByNameIgnoreCaseContaining(String mediaName);

    Page<AdminMediaEntity> findAll(Pageable pageable);

    List<AdminMediaEntity> findBySubCategoryId(String subCategoryId);

    Page<AdminMediaEntity> findByOrderByCreatedDateDesc(Pageable pageable);

    Page<AdminMediaEntity> findByOrderByTotalOrdersDesc(Pageable pagingSort);

    @Query("SELECT u FROM AdminMediaEntity u join u.tags t WHERE t.tag like %:searchKey%")
    List<AdminMediaEntity> search(@Param("searchKey") String searchKey);
}
