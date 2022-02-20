package com.tse.archintiers.photosharing.service.interfaces;

import com.tse.archintiers.photosharing.model.dto.Album;
import java.util.List;
import javax.transaction.Transactional;


public interface AlbumService {

    @Transactional
    Album getAlbumFromUser(Long id, Long userId);

    List<Album> listAlbumsFromUser(Long userId);

    Album createNewAlbumForUser(Album album, Long userId);

    Album updateAlbumForUser(Long id, Album album, Long userId);
}