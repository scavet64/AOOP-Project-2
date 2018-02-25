package commandpattern.modules;

import commandpattern.model.Button;
import dagger.Module;
import dagger.Provides;

import java.util.ArrayList;
import java.util.List;

@Module
public class RemoteControlModule {
//    @Provides static ArrayList<Button> provideButtons(ArrayList<Button> buttons) {
//        return buttons;
//    }

    @Provides static ArrayList<Button> provideButtons() {
        return new ArrayList<Button>();
    }
}
