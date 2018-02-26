package newLife.GameOfLife;

import dagger.Module;
import dagger.Provides;

import java.util.BitSet;

@Module
public class BoardModules {

    private final int width;
    private final int height;

    public BoardModules(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Provides
    WrappedBoard provideBoard(){
        return new WrappedBoard(width, height, new ConwaysCellRules(), new BitSet(width * height));
    }
}
