package common.views;

public abstract class AbstractView<T> implements View<T> {

    protected OutputWindowView outputWindowView;

    public AbstractView(OutputWindowView outputWindowView){
        this.outputWindowView = outputWindowView;
    }
}