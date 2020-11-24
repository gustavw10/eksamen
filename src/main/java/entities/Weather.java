/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Gustav
 */
@Entity
public class Weather implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String[] coord;
    private String[] weather;
//    private String base;
//    private String[] main;
//    private String visibility;
//    private String[] wind;
//    private String[] clouds;
//    private String dt;
//    private String[] sys;
//    private String name;
//    private String cod;

    public Weather(String[] coord, String[] weather, String base, String[] main, String visibility, String[] wind, String[] clouds, String dt, String[] sys, String name, String cod) {
        
        this.coord = coord;
        this.weather = weather;
//        this.base = base;
//        this.main = main;
//        this.visibility = visibility;
//        this.wind = wind;
//        this.clouds = clouds;
//        this.dt = dt;
//        this.sys = sys;
//        this.name = name;
//        this.cod = cod;
    }

    public Weather() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getCoord() {
        return coord;
    }

    public void setCoord(String[] coord) {
        this.coord = coord;
    }

    public String[] getWeather() {
        return weather;
    }

    public void setWeather(String[] weather) {
        this.weather = weather;
    }
//
//    public String getBase() {
//        return base;
//    }
//
//    public void setBase(String base) {
//        this.base = base;
//    }
//
//    public String[] getMain() {
//        return main;
//    }
//
//    public void setMain(String[] main) {
//        this.main = main;
//    }
//
//    public String getVisibility() {
//        return visibility;
//    }
//
//    public void setVisibility(String visibility) {
//        this.visibility = visibility;
//    }
//
//    public String[] getWind() {
//        return wind;
//    }
//
//    public void setWind(String[] wind) {
//        this.wind = wind;
//    }
//
//    public String[] getClouds() {
//        return clouds;
//    }
//
//    public void setClouds(String[] clouds) {
//        this.clouds = clouds;
//    }
//
//    public String getDt() {
//        return dt;
//    }
//
//    public void setDt(String dt) {
//        this.dt = dt;
//    }
//
//    public String[] getSys() {
//        return sys;
//    }
//
//    public void setSys(String[] sys) {
//        this.sys = sys;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCod() {
//        return cod;
//    }
//
//    public void setCod(String cod) {
//        this.cod = cod;
//    }
//    
//    
//    
}
