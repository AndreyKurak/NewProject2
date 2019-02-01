package spring_library.command_options;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class AddCommandOptions {

    @NotNull
    private String author;

    @NotNull
    private String title;

    @Digits(integer = 4, fraction = 0)
    private String year;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
