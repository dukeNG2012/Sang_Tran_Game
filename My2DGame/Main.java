import javax.swing.JFrame;

public class Main{
    public static void main(String[] args)
    {
       JFrame window = new JFrame(); 

       //* this will let window close properly */
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


       //* Set resizeable so we cant resize window */

       window.setResizable(true);

       /* set title */
       window.setTitle("2D Adventure");

       //* this will let all our attribute to window frame */
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        //* If we dont have this line, window wont display ur game panel! */
        window.pack();


       window.setLocationRelativeTo(null);

       //* So we can see our screen */
       window.setVisible(true);

       gamePanel.startGameThread();
    }
}