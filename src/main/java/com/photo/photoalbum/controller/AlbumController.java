package com.photo.photoalbum.controller;

import com.photo.photoalbum.dto.AlbumDto;
import com.photo.photoalbum.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController //해당 클래스가 Spring에서 관리하는 Controller라는 것을 나타내고, REST API 목적으로 사용할 것임을 나타냄
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @RequestMapping(value = "/{albumId}", method = RequestMethod.GET)
    public ResponseEntity<AlbumDto> getAlbum(@PathVariable("albumId") final long albumId) {
        //ResponseEntity<T> : T = 출력할 Dto 클래스
        AlbumDto album = albumService.getAlbum(albumId);

        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<AlbumDto> createAlbum(@RequestBody final AlbumDto albumDto) throws IOException {
        //http가 POST이기 때문에 RequestBody를 통해서 받는다

        AlbumDto savedAlbumDto = albumService.createAlbum(albumDto);
        return new ResponseEntity<>(savedAlbumDto, HttpStatus.OK);
    }
}
