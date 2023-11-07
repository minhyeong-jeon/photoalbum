package com.photo.photoalbum.service;

import com.photo.photoalbum.domain.Album;
import com.photo.photoalbum.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //스프링 컨테이너 내에 있는 모든 빈을 DI로 가져와서 사용할 수 있도록 한다
@Transactional
class AlbumServiceTest {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;

    @Test
    void getAlbum() {

        // 테스트 앨범을 생성해서 DB에 저장
        Album album = new Album();
        album.setAlbumName("테스트");
        Album saveAlbum = albumRepository.save(album);

        //앨범 id로 데이터가 조회되는지 확인
        Album resAlbum = albumService.getAlbum(saveAlbum.getAlbumId()); //앨범 id로 조회
        assertEquals("테스트", resAlbum.getAlbumName());

    }

    @Test
    void getAlbumName() {
        Album album = new Album();
        album.setAlbumName("테스트2");
        Album save = albumRepository.save(album);

        Album find = albumService.getAlbumName(save.getAlbumName());
        assertEquals("테스트2", save.getAlbumName());
    }
}