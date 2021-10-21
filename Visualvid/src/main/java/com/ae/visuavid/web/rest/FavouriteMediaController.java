package com.ae.visuavid.web.rest;

import com.ae.visuavid.domain.AdminMediaEntity;
import com.ae.visuavid.domain.CartInfo;
import com.ae.visuavid.service.FavouriteMediaService;
import com.ae.visuavid.service.dto.AdminMediaDTO;
import com.ae.visuavid.service.dto.CartDTO;
import com.ae.visuavid.service.dto.FaviouriteDTO;
import com.ae.visuavid.service.dto.UserDTO;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faviourite")
public class FavouriteMediaController {
    @Autowired
    FavouriteMediaService favouriteMediaService;

    private static final Logger log = LoggerFactory.getLogger(FavouriteMediaController.class);

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody FaviouriteDTO dto) {
        log.info("saving Faviourite Media");
        ResponseEntity<String> res = favouriteMediaService.save(dto);
        return res;
    }

    @PostMapping("/getFavouriteMedais")
    public ResponseEntity<Set<AdminMediaDTO>> getFavouriteMedais(@RequestBody UserDTO dto) {
        log.info("get Faviourite Media");
        ResponseEntity<Set<AdminMediaDTO>> res = favouriteMediaService.getFavouriteMedais(dto);
        return res;
    }

    @GetMapping("/addToCart/{mediaId}/{userId}")
    public ResponseEntity<?> addProductToCart(@PathVariable("mediaId") UUID mediaId, @PathVariable("userId") UUID userId) {
        //AdminMediaEntity media = favouriteMediaService.findMedia(mediaId);
        CartDTO cart = new CartDTO();
        //UUID mediaId=media.getId();
        cart.setMediaId(mediaId);
        cart.setUserId(userId);
        favouriteMediaService.addMediaToCart(cart);
        Set<AdminMediaDTO> setMedia = favouriteMediaService.getMediaInCart(userId);

        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
            .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
            .body(setMedia);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/getShoppingCart/{userId}")
    public ResponseEntity<?> getProductToCart(@PathVariable("userId") UUID userId) {
        log.info("get Cart Items");
        return new ResponseEntity<Set<AdminMediaDTO>>((Set<AdminMediaDTO>) favouriteMediaService.getMediaInCart(userId), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @DeleteMapping("/removeItemFromCart/{mediaId}/{userId}")
    public ResponseEntity<?> removeItemFromCart(@PathVariable("mediaId") UUID mediaId, @PathVariable("userId") UUID userId) {
        log.info("Delete Cart Items");
        favouriteMediaService.removeItemFromCart(mediaId, userId);
        return new ResponseEntity<Set<AdminMediaDTO>>((Set<AdminMediaDTO>) favouriteMediaService.getMediaInCart(userId), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @DeleteMapping("/removeItemFromWishList/{mediaId}/{userId}")
    public ResponseEntity<?> removeItemFromWishList(@PathVariable("mediaId") UUID mediaId, @PathVariable("userId") UUID userId) {
        log.info("Delete WishList Items");
        return favouriteMediaService.removeItemFromWishList(mediaId, userId);
    }

    @SuppressWarnings("unchecked")
    @DeleteMapping("/deleteAllItemsFromCart/{userId}")
    public void deleteAllItemsFromCart(@PathVariable("userId") UUID userId) {
        log.info("Delete Cart Items");
        favouriteMediaService.deleteAllItemsFromCart(userId);
    }
}
