package org.xxx.torg;

public class App {
    private boolean isRunning;

    App()
    {
        this.isRunning = false;
    }

    public void Run()
    {
        this.isRunning = true;

        do {

        }
        while ( isRunning );
    }
}
