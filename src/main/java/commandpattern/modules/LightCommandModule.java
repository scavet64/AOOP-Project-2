package commandpattern.modules;

import commandpattern.model.Light;
import dagger.Module;
import dagger.Provides;

@Module
public class LightCommandModule {

    @Provides
    public static Light providesLight(){
        return new Light();
    }
}
