package lib.commands;

import common.Command;
import common.ViewModel;
import common.views.ErrorView;
import lib.Book;
import common.views.ListView;
import lib.connectors.*;
import lib.command_options.ListCommandOptions;
import lib.global_options.GlobalOptions;

import java.util.ArrayList;
import java.util.List;

public class ListCommand implements Command<ListCommandOptions, GlobalOptions> {

    public ViewModel execute(ListCommandOptions options, GlobalOptions globalOptions) {
        ViewModel viewModel = new ViewModel();

        DataConnectionSelector dcs = new DataConnectionSelector();
        try{
            DataConnection dbc = dcs.select(globalOptions);
            Books books = dbc.read();

            if (options.getAll() != null) {
                viewModel.setModel(books.list());
            }
            else{
                List<String> singleParameters = new ArrayList<>();
                for (Book book : books.list()){
                    if (options.getAuthors() != null)
                        singleParameters.add(book.getAuthor());
                    if (options.getTitles() != null)
                        singleParameters.add(book.getTitle());
                    if (options.getYears() != null)
                        singleParameters.add(book.getYear());
                }
            viewModel.setModel(singleParameters);
            }
            viewModel.setView(new ListView());
        }
        catch (Exception ex){
            System.out.println(ex.getClass());
            System.out.println(ex.getCause());
            viewModel.setModel("List-command failed");
            viewModel.setView(new ErrorView());
        }
        return viewModel;
    }
}