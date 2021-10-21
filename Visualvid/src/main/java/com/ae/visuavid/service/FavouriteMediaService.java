package com.ae.visuavid.service;

import com.ae.visuavid.domain.AddFavourite;
import com.ae.visuavid.domain.AdminMediaEntity;
import com.ae.visuavid.domain.CartInfo;
import com.ae.visuavid.domain.User;
import com.ae.visuavid.repository.AdminMediaRepository;
import com.ae.visuavid.repository.CartRepository;
import com.ae.visuavid.repository.FavouriteMediaRepository;
import com.ae.visuavid.repository.UserRepository;
import com.ae.visuavid.service.dto.AdminMediaDTO;
import com.ae.visuavid.service.dto.CartDTO;
import com.ae.visuavid.service.dto.FaviouriteDTO;
import com.ae.visuavid.service.dto.UserDTO;
import com.ae.visuavid.service.mapper.AdminMediaMapper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FavouriteMediaService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminMediaRepository adminMediaRepository;

    @Autowired
    AdminMediaMapper mapper;

    @Autowired
    FavouriteMediaRepository favRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    CartRepository cartRepo;

    public ResponseEntity<String> save(FaviouriteDTO dto) {
        //AddFavourite fav = new AddFavourite();
        Optional<User> user = userRepository.findById(dto.getUserId());

        Set<AddFavourite> set = new HashSet<>();

        user.ifPresent(
            userObj -> {
                AddFavourite addFav = new AddFavourite();
                //userObj.setFavourite_medias(set);
                //userRepository.save(obj);
                addFav.setUser(userObj);
                addFav.setSlideName(dto.getSlideName());
                addFav.setMediaId(dto.getMediaId());
                favRepo.save(addFav);
            }
        );
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
            .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
            .body("Wishlist added Successfully");
    }

    public ResponseEntity<Set<AdminMediaDTO>> getFavouriteMedais(UserDTO dto) {
        Optional<User> user = userRepo.findById(dto.getId());
        Set<AdminMediaDTO> media = new HashSet<>();
        if (user.isPresent()) {
            try {
                User userObj = user.get();
                userObj
                    .getFavourite_medias()
                    .forEach(
                        favMedia -> {
                            AdminMediaEntity obj = adminMediaRepository.getOne(favMedia.getMediaId());
                            AdminMediaDTO adminDto = mapper.toDto(obj);
                            media.add(adminDto);
                        }
                    );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
            .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
            .body(media);
    }

    public void addMediaToCart(CartDTO cart) {
        Optional<User> user = userRepository.findById(cart.getUserId());
        user.ifPresent(
            obj -> {
                CartInfo cartObj = new CartInfo();
                userRepository.save(obj);
                cartObj.setJhi_user(obj);
                cartObj.setMediaName(cart.getMediaName());
                cartObj.setMediaId(cart.getMediaId());
                cartRepo.save(cartObj);
            }
        );
    }

    public Set<AdminMediaDTO> getMediaInCart(UUID userId) {
        Optional<User> user = userRepo.findById(userId);
        Set<AdminMediaDTO> media = new HashSet<>();
        if (user.isPresent()) {
            User userObj = user.get();
            userObj
                .getCartMedia()
                .forEach(
                    favMedia -> {
                        AdminMediaEntity obj = adminMediaRepository.getOne(favMedia.getMediaId());
                        AdminMediaDTO adminDto = mapper.toDto(obj);
                        media.add(adminDto);
                    }
                );
        }
        return media;
    }

    public void removeItemFromCart(UUID mediaId, UUID userId) {
        Optional<User> user = userRepo.findById(userId);
        try {
            if (user.isPresent()) {
                User userObj = user.get();
                userObj
                    .getCartMedia()
                    .forEach(
                        cart -> {
                            if (cart.getMediaId().equals(mediaId)) {
                                userObj.getCartMedia().remove(cart);
                            }
                        }
                    );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAllItemsFromCart(UUID userId) {
        Optional<User> user = userRepo.findById(userId);
        try {
            if (user.isPresent()) {
                User userObj = user.get();
                Set<CartInfo> set = new HashSet<>();
                set = userObj.getCartMedia();
                for (Iterator<CartInfo> iterator = set.iterator(); iterator.hasNext();) {
                    CartInfo cart = iterator.next();
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity<Set<AdminMediaDTO>> removeItemFromWishList(UUID mediaId, UUID userId) {
        Optional<User> user = userRepo.findById(userId);
        try {
            if (user.isPresent()) {
                User userObj = user.get();
                userObj
                    .getFavourite_medias()
                    .forEach(
                        wish -> {
                            if (wish.getMediaId().equals(mediaId)) {
                                userObj.getFavourite_medias().remove(wish);
                            }
                        }
                    );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<AdminMediaDTO> media = new CopyOnWriteArraySet<AdminMediaDTO>();
        Optional<User> userNew = userRepo.findById(userId);
        if (userNew.isPresent()) {
            try {
                User userObj = userNew.get();
                userObj
                    .getFavourite_medias()
                    .forEach(
                        favMedia -> {
                            AdminMediaEntity obj = adminMediaRepository.getOne(favMedia.getMediaId());
                            AdminMediaDTO adminDto = mapper.toDto(obj);
                            media.add(adminDto);
                        }
                    );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
            .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
            .body(media);
    }
}
