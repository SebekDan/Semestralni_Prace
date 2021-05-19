package base.classes;

import com.company.Player;
import interfaces.ICommand;

import java.util.Scanner;

public class Command implements ICommand {

    String commandName;
    String commandDescription;

    protected Command(){

    }

    protected Command(String commandName, String commandDescription){
        this.commandName = commandName;
        this.commandDescription = commandDescription;
    }
    @Override
    public void Execute(){
        System.out.println("BASE CLASS");
    }

    @Override
    public String GetCommandName(){
        return  commandName;
    }

    @Override
    public String GetCommandDescription(){return commandDescription;}
}