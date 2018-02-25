package commandpattern.commands;

import commandpattern.Command;
import commandpattern.model.Light;

import javax.inject.Inject;

public class LightOnCommand implements Command {

    private Light light;

    @Inject
    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOn();
        System.out.println("Turning Light on");
    }

}
