package com.ae.visuavid.repository;

import com.ae.visuavid.domain.MediaTags;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MediaTagsRepository extends JpaRepository<MediaTags, UUID> {
    @Query("SELECT m FROM MediaTags m WHERE m.tag = ?2")
    List<MediaTags> search(String searchKey);
}
