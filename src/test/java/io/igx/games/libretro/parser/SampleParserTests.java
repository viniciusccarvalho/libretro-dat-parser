package io.igx.games.libretro.parser;


import io.igx.games.libretro.model.Dat;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class SampleParserTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void parseAllFiles() throws Exception {
        File currentPath = new File(System.getProperty("user.dir"));
        File databasePath = new File(currentPath.getParent(), "libretro-database");

        if(!databasePath.exists()) {
            logger.error("Can not run any tests, path with dat files does not exist");
            return;
        }
        DatFileVisitor datFileVisitor = new DatFileVisitor();
        Files.walkFileTree(databasePath.toPath(), datFileVisitor);
        List<File> filesToVisit = datFileVisitor.getFiles();
        logger.info("Starting parser for {} files", filesToVisit.size());
        for (File file : filesToVisit) {
            try {
                DatParser parser = new DatParser(file);
                Dat dat = parser.parse();
            }catch (Exception e) {
                logger.error("Could not parse file " + file, e);
            }
        }

    }

    class DatFileVisitor extends SimpleFileVisitor<Path> {
        private List<File> datFiles = new LinkedList<>();

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            if(file.toFile().getName().endsWith(".dat")){
                datFiles.add(file.toFile());
            }
            return FileVisitResult.CONTINUE;
        }

        public List<File> getFiles() {
            return datFiles;
        }
    }

}
