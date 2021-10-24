package org.xxx.torg.console;

import java.util.EnumMap;

public class SystemConsole extends Console {

    public SystemConsole() {
        strm = System.out; // We use the native system terminal as output.

        colorMap = new EnumMap<ConsoleColor, Object>(ConsoleColor.class); // Our colors will resolve to Strings, see functions like say for an explanation.

        // Linux
        /*
        colorMap.put(ConsoleColor.BLACK, "\\e[0;30m");
        colorMap.put(ConsoleColor.WHITE, "");
        colorMap.put(ConsoleColor.RED, "\\e[0;31m");
        colorMap.put(ConsoleColor.GREEN, "");
        colorMap.put(ConsoleColor.BLUE, "\\e[0;34m");
        colorMap.put(ConsoleColor.YELLOW, "");
*/
        // Windows

        colorMap.put(ConsoleColor.BLACK, "\u001B[30m");
        colorMap.put(ConsoleColor.WHITE, "\u001B[97m");
        colorMap.put(ConsoleColor.GRAY, "\u001B[37m");
        colorMap.put(ConsoleColor.RED, "\u001B[31m");
        colorMap.put(ConsoleColor.GREEN, "\u001B[32m\t");
        colorMap.put(ConsoleColor.BLUE, "\u001B[34m");
        colorMap.put(ConsoleColor.YELLOW, "\u001B[33m");
    }

    @Override
    public void Print(String s) {
        strm.print(s);
    }

    public void Say(ConsoleColor c, String name, String msg) {
        Print(_c(ConsoleColor.BLACK) + "[" + _c(c) + name + _c(ConsoleColor.BLACK) + "] says \"" + _c(ConsoleColor.GRAY) + msg + _c(ConsoleColor.WHITE) + "\".\n\r");
    }
}
