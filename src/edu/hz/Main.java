package edu.hz;

import edu.hz.io.*;
import edu.hz.statement.HZMissionStatement;

public class Main {

    public static void main(String[] args) {

        // define
        ConsoleWriter writer = new ConsoleWriter();
        ConsoleReader reader = new ConsoleReader();

        // execute
        HZMissionStatement HZIP = new HZMissionStatement();

        writer.writeLines(HZIP.getFirstAmbition());
//        reader.readLine();

    }
}
