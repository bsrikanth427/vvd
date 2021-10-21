package com.ae.visuavid.repository;

import com.ae.visuavid.domain.AddFavourite;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteMediaRepository extends JpaRepository<AddFavourite, UUID> {
    //	@Query("select m from AddFavourite m where m.user_id=:id")
    //	Set<AddFavourite> getMediaByUserId(UUID id);
}
