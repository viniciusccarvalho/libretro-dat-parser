package io.igx.games.libretro.model;

import java.util.LinkedList;
import java.util.List;

public class Game {

    private String name;
    private String serial;
    private String year;
    private String developer;
    private String region;
    private String description;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private List<Rom> roms = new LinkedList<>();

    public List<Rom> getRoms() {
        return roms;
    }

    public void setRoms(List<Rom> roms) {
        this.roms = roms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
