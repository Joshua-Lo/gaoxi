package com.gaoxi.GaoxiUser.domain;

import javax.persistence.*;

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imgId")
    private String imgid;

    private String tag;

    @Column(name = "authorId")
    private Long authorid;

    private String content;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return imgId
     */
    public String getImgid() {
        return imgid;
    }

    /**
     * @param imgid
     */
    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    /**
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @return authorId
     */
    public Long getAuthorid() {
        return authorid;
    }

    /**
     * @param authorid
     */
    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}