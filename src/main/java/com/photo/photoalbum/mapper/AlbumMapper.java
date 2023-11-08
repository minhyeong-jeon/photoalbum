package com.photo.photoalbum.mapper;

import com.photo.photoalbum.domain.Album;
import com.photo.photoalbum.dto.AlbumDto;

public class AlbumMapper {

    //mapper는 온전히 값을 매핑해주는 용도 => 객체를 만들 필요가 없으니 ststic 메서드로 만든다.
    public static AlbumDto convertToDto(Album album) {
        AlbumDto albumDto = new AlbumDto();
        albumDto.setAlbumId(album.getAlbumId());
        albumDto.setAlbumName(album.getAlbumName());
        albumDto.setCreatedAt(album.getCreateAt());
        return albumDto;
    }
}
