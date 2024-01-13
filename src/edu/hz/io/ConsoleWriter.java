package edu.hz.io;

public class ConsoleWriter {

    public void writeLine(String line) {
        System.out.println(line);
    }

    public void writeLines(String[] lines) {
        for(String line : lines)
            System.out.println(line); }
}