package io.igx.games.libretro.model;

public class Rom {

    private String file;
    private Long size;
    private String crc;
    private String serial;
    private String md5;
    private String sha1;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }
}
