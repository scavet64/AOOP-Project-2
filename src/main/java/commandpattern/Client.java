package commandpattern;

import commandpattern.commands.LightOffCommand;
import commandpattern.commands.LightOnCommand;
import commandpattern.model.Button;
import commandpattern.model.Light;
import commandpattern.modules.LightCommandModule;
import commandpattern.modules.RemoteControlModule;
import dagger.Component;
import javax.inject.Singleton;

public class Client {

    @Singleton
    @Component(modules = {RemoteControlModule.class, LightCommandModule.class})
    public interface RemoteController {
        RemoteControl controller();
    }

    public static void main(String[] args)    {

        RemoteControl controller = DaggerClient_RemoteController.builder().build().controller();

        Light kitchenLight = new Light();

        controller.addOnCommand(new LightOnCommand(kitchenLight));
        controller.addOffCommand(new LightOffCommand(kitchenLight));
        controller.addButton(new Button(new LightOffCommand(kitchenLight)));


        controller.turnAllOn();
        controller.turnAllOff();

        controller.pressButton(0);
    }

}
