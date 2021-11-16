package io.igx.games.libretro.parser;

import io.igx.games.libretro.model.Dat;
import io.igx.games.parser.antlr.DatfileLexer;
import io.igx.games.parser.antlr.DatfileParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;

public class DatParser implements Parser<Dat> {

    private io.igx.games.parser.antlr.DatfileParser.DatContext tree;
    private DatfileParserListener listener;

    public DatParser(File file) {
        Lexer lexer = null;
        try {
            lexer = new DatfileLexer(CharStreams.fromStream(new FileInputStream(file)));
            lexer.removeErrorListener(ConsoleErrorListener.INSTANCE);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        TokenStream tokenStream = new CommonTokenStream(lexer);
        DatfileParser parser = new DatfileParser(tokenStream);
        parser.removeErrorListeners();
        this.tree = parser.dat();
        this.listener = new DatfileParserListener();
    }

    @Override
    public Dat parse() {
        ParseTreeWalker.DEFAULT.walk(listener, this.tree);
        Dat dat = new Dat();
        dat.setGames(listener.getGames());
        dat.setHeader(listener.getHeader());
        return dat;
    }

}
