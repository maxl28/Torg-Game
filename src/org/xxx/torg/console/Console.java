package org.xxx.torg.console;

import java.io.PrintStream;
import java.util.Map;

// Abstract classes don't need their class functions to have a body.
public abstract class Console {
    protected PrintStream strm;
    protected Map<ConsoleColor, Object> colorMap;

    public abstract void Print(String s);

    public abstract void Say(ConsoleColor c, String name, String msg);

    /**
     * Resolve an SystemColor enum entry to an actually usable color.
     *
     * @param c
     * @return Corresponding System.out color code
     */
    public Object _c(ConsoleColor c) {
        return "" + colorMap.get(c);
    }
}
