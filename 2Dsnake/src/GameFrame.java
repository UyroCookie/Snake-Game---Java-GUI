import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class GameFrame extends JFrame{
    public GameFrame() {
        Image i = new ImageIcon(this.getClass().getResource("Snake_Game_Icon.png")).getImage();
        this.setIconImage(i);
        add(new GamePanel());
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
