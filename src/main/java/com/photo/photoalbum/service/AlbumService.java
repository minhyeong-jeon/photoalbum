package com.photo.photoalbum.service;

import com.photo.photoalbum.domain.Album;
import com.photo.photoalbum.dto.AlbumDto;
import com.photo.photoalbum.mapper.AlbumMapper;
import com.photo.photoalbum.repository.AlbumRepository;
import com.photo.photoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired  //등록된 빈을 컨테이너에서 가져와서 사용
    private AlbumRepository albumRepository;

    @Autowired
    private PhotoRepository photoRepository;

    //DTO로 변환해서 컨트롤러로 리턴해주는 게 일반적
    public AlbumDto getAlbum(long albumId){
        Optional<Album> res = albumRepository.findById(albumId);
        if (res.isPresent()) {  //값이 있는지 확인
            AlbumDto albumDto = AlbumMapper.convertToDto(res.get()); //domain -> dto 변환
            albumDto.setCount(photoRepository.countByAlbum_AlbumId(albumId)); //PhotoRepo에서 count 받아서 dto에 넣어주기

            return albumDto;
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
