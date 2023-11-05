package com.javarush.boyarinov;


import com.javarush.boyarinov.commands.StartCommands;
import com.javarush.boyarinov.view.Options;
import com.javarush.boyarinov.view.Selection;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Options options = new Options();
        StartCommands startCommands = new StartCommands();
        Selection selection = new Selection(scanner, options, startCommands);
        selection.commandSelections();

    }


}
