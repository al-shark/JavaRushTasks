package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean isContainName = true;
        boolean isContainContent = true;
        boolean isMinSize = true;
        boolean isMaxSize = true;

        if (Objects.nonNull(partOfName)) isContainName = file.getFileName().toString().contains(partOfName);
        if (Objects.nonNull(partOfContent)) isContainContent = new String(content).contains(partOfContent);
        if (! (minSize==0)) isMinSize = minSize <= content.length;
        if (! (maxSize==0)) isMaxSize = maxSize >= content.length;

        boolean result = isContainName & isContainContent & isMinSize & isMaxSize;

        if (result) foundFiles.add(file);

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
