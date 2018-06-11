package lib.commands;

import commonPac.Command;
import commonPac.InputParameters;
import commonPac.ViewModel;
import lib.Book;
import commonPac.views.MessageView;
import lib.MyLibrary;
import commonPac.OpenFileStream;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteCommand implements Command {

    private static final String FILE1 = "file1";

    public ViewModel execute(InputParameters inputParameters) {
        OpenFileStream<Book> openFileStream = new OpenFileStream<>(inputParameters.getGlobalOptions().get(FILE1));
        ViewModel viewModel = new ViewModel();

        int id = Integer.valueOf(inputParameters.getCommandOptions().get("id")) - 1;

        try {
            List<Book> books = openFileStream.read();
            books.remove(id);
            for (int i = id; i<books.size(); i++)
                books.get(id).setId(id + 1);
            openFileStream.write(books);
        }
        catch (IOException ex) {
            Logger.getLogger(MyLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MyLibrary.class.getName()).log(Level.SEVERE, null, ex);
        }

        viewModel.model = "Delete command was performed";
        viewModel.view = new MessageView();

        return viewModel;
    }
}