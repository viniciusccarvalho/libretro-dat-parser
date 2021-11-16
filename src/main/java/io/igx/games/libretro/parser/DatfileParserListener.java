package io.igx.games.libretro.parser;

import io.igx.games.libretro.model.Game;
import io.igx.games.libretro.model.Header;
import io.igx.games.libretro.model.Rom;
import io.igx.games.parser.antlr.DatfileBaseListener;
import io.igx.games.parser.antlr.DatfileParser;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class DatfileParserListener extends DatfileBaseListener {


    private List<Game> games = new LinkedList<>();
    private Stack<Game> gameStack = new Stack<>();
    private Stack<Rom> romStack = new Stack<Rom>();
    private Header header = new Header();

    @Override
    public void enterDat(DatfileParser.DatContext ctx) {
        super.enterDat(ctx);
    }

    @Override
    public void enterClr(DatfileParser.ClrContext ctx) {
        super.enterClr(ctx);
    }

    @Override
    public void enterClrBody(DatfileParser.ClrBodyContext ctx) {
        if(ctx.description() != null) {
            header.setDescription(escape(ctx.description().STRING().getText()));
        }
        if(ctx.gameName() != null) {
            header.setName(escape(ctx.gameName().STRING().getText()));
        }
        if(ctx.homepage() != null) {
            String text = (ctx.homepage().STRING() != null) ? ctx.homepage().getText() : "";
            header.setHomepage(escape(text));
        }
        if(ctx.version() != null) {
            if(ctx.version().STRING() != null) {
                header.setVersion(escape(ctx.version().STRING().getText()));
            }
            if(ctx.version().DASHED() != null){
                header.setVersion(ctx.version().DASHED().getText());
            }
        }
    }

    @Override
    public void enterGame(DatfileParser.GameContext ctx) {
        Game game = new Game();
        gameStack.push(game);
        games.add(game);
    }

    @Override
    public void exitGame(DatfileParser.GameContext ctx) {
        if(!gameStack.isEmpty()) {
            gameStack.pop();
        }
    }

    @Override
    public void enterGameBody(DatfileParser.GameBodyContext ctx) {
        if(!gameStack.isEmpty()) {
            Game game = gameStack.peek();
            if(ctx.gameName() != null){
                game.setName(escape(ctx.gameName().STRING().getText()));
            }
            if(ctx.developer() != null){
                game.setDeveloper(escape(ctx.developer().STRING().getText()));
            }
            if(ctx.year() != null){
                String text = (ctx.year().STRING() != null) ? ctx.year().getText() : "";
                game.setYear(escape(text));
            }
            if(ctx.serial() != null) {
                game.setSerial(escape(ctx.serial().STRING().getText()));
            }
        }
    }

    @Override
    public void enterRom(DatfileParser.RomContext ctx) {
        Rom rom = new Rom();
        romStack.push(rom);
        if(!gameStack.isEmpty()){
            Game game = gameStack.peek();
            game.getRoms().add(rom);
        }
    }

    @Override
    public void enterRomBody(DatfileParser.RomBodyContext ctx) {
        if(!romStack.isEmpty()) {
            Rom rom = romStack.peek();
            if(ctx.crc() != null) {
                rom.setCrc(ctx.crc().NUMERIC().getText());
            }
            if(ctx.sha1() != null){
                rom.setSha1(ctx.sha1().NUMERIC().getText());
            }
            if(ctx.md5() != null){
                rom.setMd5(ctx.md5().NUMERIC().getText());
            }
            if(ctx.size() != null){
                try{
                    rom.setSize(Long.valueOf(ctx.size().NUMERIC().getText()));
                }catch (Exception e){}
            }
            if(ctx.serial() != null) {
                rom.setSerial(escape(ctx.serial().STRING().getText()));
            }
            if(ctx.fileName() != null) {
                if(ctx.fileName().FILENAME() != null) {
                    rom.setFile(ctx.fileName().FILENAME().getText());
                }
                if(ctx.fileName().STRING() != null) {
                    rom.setFile(escape(ctx.fileName().STRING().getText()));
                }
            }

        }
    }

    private String escape(String value) {
        return value.replaceAll("\"", "");
    }

    @Override
    public void exitRom(DatfileParser.RomContext ctx) {
        romStack.pop();
    }

    public List<Game> getGames() {
        return games;
    }

    public Header getHeader() {
        return header;
    }
}
