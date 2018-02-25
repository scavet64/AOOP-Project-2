package commandpattern;

import commandpattern.model.Button;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;

public class RemoteControl {

    private ArrayList<Command> onCommands = new ArrayList<>();
    private ArrayList<Command> offCommands = new ArrayList<>();

    private ArrayList<Button> buttons;

    @Inject
    public RemoteControl(ArrayList<Button> buttons){
        this.buttons = buttons;
    }

    public void setButtons(ArrayList<Button> buttons){
        this.buttons = buttons;
    }

    public void pressButton(int buttonIndex){
        System.out.println("Pressing button: " + buttonIndex);
        buttons.get(buttonIndex).pressButton();
    }

    public void turnAllOn(){
        System.out.println("executing on commands");
        System.out.println(onCommands.size());
        for(Command command: onCommands){
            command.execute();
        }
    }

    public void turnAllOff(){
        System.out.println("executing off commands");
        System.out.println(offCommands.size());
        for(Command command: offCommands){
            command.execute();
        }
    }

    public boolean addOnCommand(Command command){
        System.out.println("Adding on Command");
        return onCommands.add(command);
    }

    public boolean addOffCommand(Command command){
        System.out.println("Adding off Command");
        return offCommands.add(command);
    }

    public boolean removeOffCommand(Command command){
        return offCommands.remove(command);
    }

    public boolean removeOnCommand(Command command){
        return onCommands.remove(command);
    }

    public void addButton(Button button){
        System.out.println("Adding Button");
        buttons.add(button);
    }

    public void removeButton(Button button){
        System.out.println("Removing Button");
        buttons.remove(button);
    }
}
