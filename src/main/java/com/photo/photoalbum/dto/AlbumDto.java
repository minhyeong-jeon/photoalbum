package com.photo.photoalbum.dto;

import java.util.Date;

/*
 * 앨범 정보를 DB에서 조회한 후, 데이터를 API Response로 보내기 위해 필요한 정보를 매핑해서 전달한다
 */
public class AlbumDto {
    long albumId;

    String albumName;

    Date createdAt;

    int count;

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
