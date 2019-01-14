package com.CloudSchool.domain;

public class Classroom {
    private Integer id;

    private String name;

    private Integer ctid;

    private Integer galleryful;

    private Integer floor;
    
    private String ctname;

    public String getCtname() {
		return ctname;
	}

	public void setCtname(String ctname) {
		this.ctname = ctname;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public Integer getGalleryful() {
        return galleryful;
    }

    public void setGalleryful(Integer galleryful) {
        this.galleryful = galleryful;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}