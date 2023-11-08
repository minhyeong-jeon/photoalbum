package com.photo.photoalbum.repository;

import com.photo.photoalbum.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    //countBy : 뒤에 붙는 조건을 기준으로 테이블에 레코드가 몇개 있는지 확인
    //Album_AlbumId : 참조하는 Album 엔티티의 AlbumId 값을 확인해, 일치하는 Photo 레코드들을 찾는다
    int countByAlbum_AlbumId(Long AlbumId); // => 특정 앨범에 속해있는 사진의 개수 구하기
}
