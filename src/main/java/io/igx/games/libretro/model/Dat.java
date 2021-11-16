package io.igx.games.libretro.model;

import java.util.LinkedList;
import java.util.List;

public class Dat {

    private List<Game> games = new LinkedList<>();
    private Header header;
    private String sourceFile;

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
