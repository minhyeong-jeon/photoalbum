package com.photo.photoalbum.repository;

import com.photo.photoalbum.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    //List<Album> findByAlbumName(String name);

    Optional<Album> findByAlbumName(String name);
}
