package lib.commands;

import common.Command;
import lib.connectors.*;
import common.ViewModel;
import lib.command_options.SearchCommandOptions;
import lib.global_options.GlobalOptions;
import lib.library_entities.Book;
import lib.library_entities.Books;
import lib.validators.Validator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchCommand implements Command<SearchCommandOptions, GlobalOptions> {

    public ViewModel execute(SearchCommandOptions options, GlobalOptions globalOptions) {
        ViewModel viewModel = new ViewModel();

        DataConnectionSelector dcs = new DataConnectionSelector();
        try{
            viewModel.setModel(new Validator().validate(options, "search"));
            if (viewModel.getModel() == null) {
                DataConnection dbc = dcs.select(globalOptions);
                Books books = dbc.read();

                Book book = new Book(options.getAuthor(), options.getTitle(), options.getYear());
                viewModel.setModel(books.search(book));
                viewModel.setViewName("ListView");
                if (viewModel.getModel() == null) {
                    viewModel.setViewName("ErrorView");
                    viewModel.setModel("nothing found");
                }
            }
            else
                viewModel.setViewName("ErrorVew");
        }
        catch (Exception ex){
            viewModel.setModel("Search-command failed:" + ex.getMessage());
            viewModel.setViewName("ErrorView");
            Logger.getLogger(SearchCommand.class.getName()).log(Level.SEVERE, "Exception:", ex);
        }
        return viewModel;
    }
}
