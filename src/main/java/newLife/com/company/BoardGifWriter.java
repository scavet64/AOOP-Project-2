package newLife.com.company;

import newLife.GameOfLife.Board;
import newLife.GameOfLife.BoardUtils;

import java.io.IOException;

//Adapter for GifSequenceWriter to BoardWriter
public class BoardGifWriter implements BoardWriter {
    newLife.com.company.GifSequenceWriter gifWriter;

    public BoardGifWriter(newLife.com.company.GifSequenceWriter gifWriter){
        this.gifWriter = gifWriter;
    }

    @Override
    public void write(Board board) throws IOException{
        gifWriter.writeToSequence(BoardUtils.boardToImage(board));
    }

    @Override
    public void close() throws IOException{
        gifWriter.close();
    }
}
