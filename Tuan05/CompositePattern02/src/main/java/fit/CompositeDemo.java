package fit;

public class CompositeDemo {
    public static void main(String[] args) {
        UIComponent button = new Button();
        UIComponent dialog = new DialogBox();
        UIComponent navBar = new NavigationBar();

        Container panel = new Container();
        panel.add(button);
        panel.add(dialog);

        Container mainWindow = new Container();
        mainWindow.add(navBar);
        mainWindow.add(panel);

        // Render toàn bộ giao diện
        mainWindow.render();
    }
}