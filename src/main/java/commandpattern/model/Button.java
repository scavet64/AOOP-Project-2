package commandpattern.model;

import commandpattern.Command;

import javax.inject.Inject;

public class Button {
    private Command command;

    @Inject
    public Button(Command command){
        this.command = command;
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}
