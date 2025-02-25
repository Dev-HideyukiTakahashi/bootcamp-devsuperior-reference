package com.devuperior.dslearn.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_course")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String imgUrl;
  private String imgGrayUri;

  @OneToMany(mappedBy = "course")
  private final List<Offer> offers = new ArrayList<>();

  public Course() {
  }

  public Course(Long id, String name, String imgUrl, String imgGrayUri) {
    this.id = id;
    this.name = name;
    this.imgUrl = imgUrl;
    this.imgGrayUri = imgGrayUri;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getImgGrayUri() {
    return imgGrayUri;
  }

  public void setImgGrayUri(String imgGrayUri) {
    this.imgGrayUri = imgGrayUri;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  public List<Offer> getOffers() {
    return offers;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Course other = (Course) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
