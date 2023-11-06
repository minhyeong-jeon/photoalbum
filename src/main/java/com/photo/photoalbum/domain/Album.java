package com.photo.photoalbum.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity //db 테이블과 1-1로 매핑되는 클래스 단위, Entity 객체 하나가 db에서 하나의 레코드 즉 하나의 Row를 의미
@Table(name = "album", schema = "photo_album", uniqueConstraints = {@UniqueConstraint(columnNames = "album_id")})
/*
name : 테이블명
schema : 스키마명
uniqueConstraints : 반복되면 안되는 제약조건
 */
public class Album {

    @Id //해당 Entity의 PK로 사용한다는 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id값을 새롭게 부여할 때 사용하는 방법에 대한 정보 입력
                                                        //strategy = GenerationType.IDENTITY : 가장 최근 id에 +1을 해서 다음 아이디를 생성
    @Column(name = "album_id", unique = true, nullable = false)
    private Long albumId;

    @Column(name = "album_name", unique = false, nullable = false)
    private String albumName;

    @Column(name = "created_at", unique = false, nullable = true)
    @CreationTimestamp  //새로운 앨범을 생성해 DB INSERT할 때 자동으로 현재 시간을 입력
    private Date createAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album", cascade = CascadeType.ALL)
    private List<Photo> photos;
}
