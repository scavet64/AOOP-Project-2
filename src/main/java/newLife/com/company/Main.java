package newLife.com.company;

import newLife.GameOfLife.Board;
import newLife.GameOfLife.BoardUtils;
import newLife.GameOfLife.ConwaysCellRules;
import newLife.GameOfLife.WrappedBoard;
import newLife.com.company.GifSequenceWriter;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import newLife.GameOfLife.*;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.BitSet;
import java.util.Scanner;



public class Main {

    static StartingParameterValues startingParameters;

    static String[] getStartingFromUser(){
        String[] output = new String[4];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Board Size: ");
        output[0] = scanner.next();
        System.out.print("Number Of Runs: ");
        output[1] = scanner.next();
        System.out.print("Output Filename: ");
        output[2] = scanner.next();
        System.out.print("Starting Board: ");
        output[3] = scanner.next();
        return output;
    }

    @Singleton
    @Component(modules = {BoardModules.class})
    public interface BoardInterface {
        WrappedBoard getBoard();
    }


    public static void main(String[] args) throws IOException{
        if(args.length != 4){
            args = getStartingFromUser();
        }

        if(args.length != 4){
            System.out.println("Invalid starting information.");
        }else{
            startingParameters = new StartingParameterValues(new StartingParameterStrings(args));
            System.out.println("Starting Parameters: "+startingParameters);

            BoardInterface bi = DaggerMain_BoardInterface
                    .builder()
                    .boardModules(new BoardModules(startingParameters.width, startingParameters.height))
                    .build();
            WrappedBoard boardDagger = bi.getBoard();
            BoardUtils.makeGifFromRun(startingParameters.outputFilename, boardDagger, startingParameters.numberOfRuns, startingParameters.startingBoard, startingParameters.startingBoardWidth, startingParameters.startingBoardHeight);
        }
    }


}
