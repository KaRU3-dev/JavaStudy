public class App {
    public static void main(String[] args) throws Exception {
        FrameManager mainFrame = new FrameManager("RPG Game", 800, 900);

        mainFrame.createFrameComponents();
        mainFrame.tempSetPlayer();

        mainFrame.setVisible(true);
    }
}
