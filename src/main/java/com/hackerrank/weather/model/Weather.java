package com.hackerrank.weather.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date dateRecorded;

    private Float lat;
    private Float lon;
    private String city;
    private String state;

    private Double temperature;

    public Weather() {
    }

    public Weather(final Date dateRecorded, final String city, final String state, final Float lat, final Float lon,
        final Double temperature) {
      this.dateRecorded = dateRecorded;
      this.lat = lat;
      this.lon = lon;
      this.city = city;
      this.state = state;
      this.temperature = temperature;
    }

    public Weather(final Integer id, final Date dateRecorded, final String city, final String state, final Float lat,
        final Float lon, final Double temperature) {
      this.id = id;
      this.dateRecorded = dateRecorded;
      this.lat = lat;
      this.lon = lon;
      this.city = city;
      this.state = state;
      this.temperature = temperature;
    }

    public Integer getId() {
      return id;
    }

    public void setId(final Integer id) {
      this.id = id;
    }

    public Date getDateRecorded() {
      return dateRecorded;
    }

    public void setDateRecorded(final Date dateRecorded) {
      this.dateRecorded = dateRecorded;
    }

    public String getCity() {
      return city;
    }

    public void setCity(final String city) {
      this.city = city;
    }

    public String getState() {
      return state;
    }

    public void setState(final String state) {
      this.state = state;
    }

    public Float getLat() {
      return lat;
    }

    public void setLat(final Float lat) {
      this.lat = lat;
    }

    public Float getLon() {
      return lon;
    }

    public void setLon(final Float lon) {
      this.lon = lon;
    }

    public Double getTemperature() {
      return temperature;
    }

    public void setTemperature(final Double temperature) {
        this.temperature = temperature;
    }
}
