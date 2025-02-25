package com.devuperior.dslearn.entities.pk;

import com.devuperior.dslearn.entities.Offer;
import com.devuperior.dslearn.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EnrollmentPK {

  @ManyToOne
  private User user;

  @ManyToOne
  private Offer offer;

  public EnrollmentPK() {
  }

  public EnrollmentPK(User user, Offer offer) {
    this.user = user;
    this.offer = offer;
  }

  public User getUser() {
    return user;
  }

  public Offer getOffer() {
    return offer;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setOffer(Offer offer) {
    this.offer = offer;
  }

}
