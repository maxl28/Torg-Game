package org.xxx.torg.console;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Scanner;

public class SystemConsole extends Console {

    public SystemConsole() {
        out = System.out; // We use the native system terminal as output.
        in = System.in;

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
        colorMap.put(ConsoleColor.WHITE, "\u001B[37m");
        colorMap.put(ConsoleColor.GRAY, "\u001B[90m");
        colorMap.put(ConsoleColor.RED, "\u001B[91m");
        colorMap.put(ConsoleColor.GREEN, "\u001B[32m");
        colorMap.put(ConsoleColor.BLUE, "\u001B[34m");
        colorMap.put(ConsoleColor.YELLOW, "\u001B[33m");
    }

    @Override
    public void Print(String s) {
        out.print(s);
    }

    public void Say(ConsoleColor c, String name, String msg) {
        Print(_c(ConsoleColor.WHITE) + "[" + _c(c) + name + _c(ConsoleColor.WHITE) + "] says \"" + _c(ConsoleColor.GRAY) + msg + _c(ConsoleColor.WHITE) + "\".\n\r");
        try {
            in.read(); // Wait for player to press enter key
        } catch (IOException e) {}
    }

    public void Inspect(Object o)
    {
        Class<?> cls = o.getClass();

        Print( "\n\r\n\r" );
        Print( _c(ConsoleColor.GREEN) + cls.getName() + _c(ConsoleColor.WHITE) + ": \n\r");

        for(Iterator<Field> i = Arrays.stream(cls.getDeclaredFields()).iterator(); i.hasNext();) {
            Field field = i.next();
            try {
                Print(_c(ConsoleColor.WHITE) + "{" + _c(ConsoleColor.GRAY) + field.getName() + _c(ConsoleColor.WHITE) + "} " + _c(ConsoleColor.GRAY) + field.get(this).toString() + "\n\r" );
            } catch (Exception e) {} // Private fields will throw an exception
        }
    }
}
