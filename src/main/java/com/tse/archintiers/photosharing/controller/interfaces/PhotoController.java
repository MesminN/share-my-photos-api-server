package com.tse.archintiers.photosharing.controller.interfaces;

import com.tse.archintiers.photosharing.model.dto.Photo;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/photo")
public interface PhotoController {

    @GetMapping(value="/{id}")
    ResponseEntity<Photo> getPhoto(@PathVariable(value = "id") Long id, Authentication authentication);

    @GetMapping(value="/")
    ResponseEntity<List<Photo>> listPhotos(Authentication authentication);

    @PostMapping(value="/upload")
    ResponseEntity<Photo> uploadImage(@RequestParam("file") MultipartFile file,
                                      @RequestParam(name="description", required = false) String imageDesc,
                                      @RequestParam(name = "album", required = false) Long albumId,
                                      @RequestParam(name = "type", required = false) String type,
                                      Authentication authentication) throws Exception;
}
