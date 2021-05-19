package commands;

import base.classes.BasicCommand;
import com.company.GamePlan;
import com.company.Player;
import com.company.UserInput;
import interfaces.ICommand;
import interfaces.IItem;

import java.util.Scanner;

public class CommandTakeOutBackpack extends BasicCommand implements ICommand {
    public CommandTakeOutBackpack(String commandName,String commandDescription){
        super(commandName,commandDescription);
    }

    @Override
    public void Execute(){
        if(GamePlan.GetPlayer().GetPlayerBackpack().HaveInteractableItem() == 'Y'){
            System.out.print("Jaký předmět chceš vyndat z batohu?" + "\n" + GamePlan.GetPlayer().GetPlayerBackpack().ShowItemsInBackpack() + "\n" + "Předmět: ");
            String itemName = UserInput.ReadUserInput();
            IItem itemFromBackpack = GamePlan.GetPlayer().GetPlayerBackpack().OnTakeOut(itemName);
            if(itemFromBackpack != null){
                System.out.print(itemFromBackpack.OnItemTakeOutBackpack());
                GamePlan.GetPlayer().GetCurrentRoom().AddItemInRoom(itemFromBackpack);
            }else{
                System.out.print("Takový předmět v batohu nenáš, promiň...");
            }
        }else{
            System.out.print("Bohužel v batohu nic nemáš, promiň...");
        }

    }
}
