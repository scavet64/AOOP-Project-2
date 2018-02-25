package commandpattern.commands;

import commandpattern.Command;
import commandpattern.model.Light;
import commandpattern.modules.LightCommandModule;
import dagger.Component;

import javax.inject.Inject;

public class LightOffCommand implements Command {

    private Light light;

    @Inject
    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOff();
    }
}
