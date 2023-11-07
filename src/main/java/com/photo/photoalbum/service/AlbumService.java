package com.photo.photoalbum.service;

import com.photo.photoalbum.domain.Album;
import com.photo.photoalbum.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired  //등록된 빈을 컨테이너에서 가져와서 사용
    private AlbumRepository albumRepository;

    public Album getAlbum(long albumId){
        Optional<Album> res = albumRepository.findById(albumId);
        if (res.isPresent()) {  //값이 있는지 확인
            return res.get();   //있는 경우, Album 엔티티 반환
        }
        else{
            throw new EntityNotFoundException(String.format("앨범 아이디 $d로 조회되지 않았습니다", albumId));
        }
    }

    public Album getAlbumName(String albumName){
        Optional<Album> res = albumRepository.findByAlbumName(albumName);
        if (res.isPresent()) {  //값이 있는지 확인
            return res.get();   //있는 경우, Album 엔티티 반환
        }
        else{
            throw new EntityNotFoundException(String.format("앨범 아이디 $d로 조회되지 않았습니다", albumName));
        }
    }
}
