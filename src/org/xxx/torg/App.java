package org.xxx.torg;

import org.xxx.torg.console.Console;
import org.xxx.torg.console.ConsoleColor;
import org.xxx.torg.console.SystemConsole;

public class App {
    private boolean isRunning; // Manage our game loop with this. If set to false from somewhere within the code, the app will stop end exit.
    private final Console Console; // Our text writer, print any string on a given display, be it the system console or a custom window.

    App() {
        this.isRunning = false;
        this.Console = new SystemConsole();
    }

    public void Run() {
        this.isRunning = true;

        boolean spoken = false;
        do {
            if (!spoken) {
                Console cn = this.getConsole();

                this.getConsole().Say(
                        ConsoleColor.RED,
                        "HIVE",
                        "Welcome traveler! Welcome to the " + Console._c(ConsoleColor.BLUE) + "Game Loop" + Console._c(ConsoleColor.BLACK) + "!"
                );
                spoken = true;
            }
        }
        while (isRunning);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Console getConsole() {
        return Console;
    }
}
