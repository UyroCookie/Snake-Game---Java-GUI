import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
    
    //Screen Variables
    int width = 700;
    int height = 500;
    int us = 25;
    int units = (width * height) / us;
    int delay = 100;
    int x[] = new int[units];
    int y[] = new int[units];
    
    //Snake Variables
    int bodyParts = 6;
    
    //Apple Variables
    int applesEaten, appleX, appleY;
    
    //Direction 
    char direction = 'R';     
    boolean running = false;
    Timer timer;
    Random random;
    boolean gameOverTriggered = false;
    
    public GamePanel() {
        random = new Random();
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(106, 85, 85));
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            //Apple
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, us, us);

            //Snake
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x[i], y[i], us, us);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], us, us);
                }
            }
            
            //Score Board
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 25));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (width - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        } else {
            gameOver(g);
        }
    }

    public void newApple() {
        appleX = random.nextInt((int) (width / us)) * us;
        appleY = random.nextInt((int) (height / us)) * us;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
            y[0] = y[0] - us;
            break;
            
            case 'D':
            y[0] = y[0] + us;
            break;
            
            case 'L':
            x[0] = x[0] - us;
            break;
            
            case 'R':
            x[0] = x[0] + us;
            break;
        }
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        // Head hit body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }
        }
        // Head hit left border
        if (x[0] < 0) {
            running = false;
        }
        // Head hit right border
        if (x[0] >= width) {
            running = false;
        }
        // Head hit top border
        if (y[0] < 0) {
            running = false;
        }
        // Head hit bottom border
        if (y[0] >= height) {
            running = false;
        }
        
        if (!running && !gameOverTriggered) {
        gameOverTriggered = true;
        timer.stop();

        Timer gameOverDelay = new Timer(3000, e -> {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
        new MainScreen().setVisible(true);
        });

        gameOverDelay.setRepeats(false);
        gameOverDelay.start();
}
    }

    public void gameOver(Graphics g) {
        // Game Over Style
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 75));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (width - metrics1.stringWidth("Game Over")) / 2, height / 2);

        // Display Score at Game Over screen
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Total Score: " + applesEaten, (width - metrics2.stringWidth("Total Score: " + applesEaten)) / 2, height / 2 + 75);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R'){ 
                        direction = 'L';
                    }
                break;
                
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L'){ 
                        direction = 'R';
                    }
                    break;
                    
                case KeyEvent.VK_UP: {
                    if (direction != 'D') {
                        direction = 'U';
                    }
                }
                case KeyEvent.VK_DOWN: {
                    if (direction != 'U'){
                        direction = 'D';
                       }
                }
            }
        }
    }
}
