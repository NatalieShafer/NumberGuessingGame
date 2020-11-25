import java.awt.*;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuessingGame{
  
  public int counter;
  public int num;
  public int number;
  public int numberofgames;
  public int won;
  public int livesNum;
  public boolean winnerorlosser;
  
  public GuessingGame()
  {    
    int hgap = 5;
    int vgap = 5;
    
    winnerorlosser = false;
    num = (int)(Math.random()*100 + 1);
    counter = 0;
    won = 0;
    numberofgames = 0;
    livesNum = 7;
    
    Color mybackground = new Color(225,225,225);
    JFrame frame = new JFrame("Number Guessing Game");
    JPanel contentPane = new JPanel();
    contentPane.setOpaque(true);
    contentPane.setBackground(mybackground);
    contentPane.setBorder(BorderFactory.createEmptyBorder(hgap, hgap, hgap, hgap));
    contentPane.setLayout(new GridLayout(2,0));
    
    JLabel label1 = new JLabel("Enter a number between 1 and 100:");
    JLabel dropdownlabel = new JLabel("Number of Guesses:");
    JLabel winvsloss = new JLabel("Success 0%");
    JLabel numberofgamesplayed = new JLabel("Number of Games Played: 0");
    
    JLabel numberofguesses = new JLabel("You have guessed 0 times.");
    JLabel hiorlo = new JLabel("Guess a Number");
    JTextField textInput = new JTextField();
    textInput.setPreferredSize(new Dimension(75, 20));
    
    JButton guess = new JButton("Guess");
    guess.setPreferredSize(new Dimension(75, 20));
    JButton newGame = new JButton("New Game");
    JButton reset = new JButton("Reset");
    JComboBox<String> lives = new JComboBox<String>(new String[] {"10", "9", "8", "7", "6", "5", "4"});
    lives.setPreferredSize(new Dimension(50, 15));
    lives.setSelectedItem("7"); 
    
    JPanel panel1 = new JPanel(); 
    panel1.setOpaque(true);
    panel1.setBackground(Color.WHITE);      
    panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
    //panel1.setPrefferedSize(60,60);
    
    GroupLayout layout = new GroupLayout(panel1);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
    
    layout.setHorizontalGroup(layout.createSequentialGroup() 
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)   
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)             
                                                        .addGroup(layout.createSequentialGroup()      
                                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) 
                                                                                .addComponent(dropdownlabel)
                                                                             )
                                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)        
                                                                                .addComponent(lives, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                             )
                                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)        
                                                                                .addComponent(numberofgamesplayed)
                                                                             )
                                                                 )
                                                        .addComponent(winvsloss)
                                                     )
                                            .addComponent(reset))
                             );
    
    layout.setVerticalGroup(layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) 
                                          .addComponent(dropdownlabel)
                                          .addComponent(lives, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                          .addComponent(numberofgamesplayed)
                                       )
                              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER) 
                                          .addComponent(winvsloss))
                              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER) 
                                          .addComponent(reset))    
                           );
    
    layout.linkSize(SwingConstants.HORIZONTAL, textInput, guess );
    layout.linkSize(SwingConstants.VERTICAL, textInput, guess);
    panel1.setLayout(layout);
    contentPane.add(panel1);
    JPanel panel2 = new JPanel(); 
    panel2.setOpaque(true);
    panel2.setBackground(Color.WHITE);      
    panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
    GroupLayout layout2 = new GroupLayout(panel2);
    layout2.setAutoCreateGaps(true);
    layout2.setAutoCreateContainerGaps(true);
    
    layout2.setHorizontalGroup(layout2.createSequentialGroup()
                                 
                                 .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.CENTER) 
                                             .addGroup(layout2.createSequentialGroup() 
                                                         .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                     .addComponent(label1)
                                                                     .addComponent(numberofguesses)           
                                                                  )
                                                         
                                                         .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.CENTER)                  
                                                                     .addGroup(layout2.createSequentialGroup()
                                                                                 .addComponent(textInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                 .addComponent(guess)   
                                                                              )
                                                                     .addComponent(hiorlo)  
                                                                  )
                                                      )
                                             
                                             
                                             .addComponent(newGame)
                                          )
                                 
                              );
    
    layout2.setVerticalGroup(layout2.createSequentialGroup()
                               .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                           .addComponent(label1)
                                           .addComponent(textInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                           .addComponent(guess)  
                                        )
                               
                               .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                           .addComponent(numberofguesses)
                                           .addComponent(hiorlo)  
                                        )
                               
                               .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.CENTER)
                                           .addComponent(newGame)
                                        )                  
                            );
    
    layout2.linkSize(SwingConstants.HORIZONTAL, textInput, guess );
    layout2.linkSize(SwingConstants.VERTICAL, textInput, guess);
    panel2.setLayout(layout2);
    contentPane.add(panel2);
    
    
    textInput.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        guess.doClick();
        
      }});
    
    textInput.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    textInput.setText("");
  }
});
    
    
    
    
    
    reset.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        num = (int)(Math.random()*100 + 1);
        number = 0;
        winnerorlosser = false;
        counter = 0 ;
        numberofgames=0;
        won=0;
        livesNum=7;
        lives.setSelectedItem("7"); 
        textInput.setText("");
        numberofguesses.setText("You have guessed 0 times.");
        hiorlo.setText("Guess a Number");
        numberofgamesplayed.setText("Number of Games Played: 0");
        winvsloss.setText("Success 0%");
      }});

    
    
    
    guess.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) { 
        
        if(winnerorlosser == false){
          
          try{
            number = Integer.parseInt(textInput.getText());
          }
          catch(Exception except){
            JOptionPane.showMessageDialog(null, "Please guess a number", "Number Guessing Game", 3);
            return;
          }
          if(number >100 || number < 1)
          { JOptionPane.showMessageDialog(null, "Please guess a number between 1 and 100", "Number Guessing Game", 3);
            textInput.setText("");
          }
          else
          {
            counter = counter + 1 ;
            numberofguesses.setText("You have guessed " + counter + " times.");
        
            if(number==num)
            {
              hiorlo.setText("WINNER!!!");
              winnerorlosser = true;
              won = won+1;
              numberofgames = numberofgames + 1;
              numberofgamesplayed.setText("Number of Games Played: "+numberofgames);
              winvsloss.setText("Success " +((100/numberofgames)*won)+"%");
            }
            
            else if(livesNum == counter)
            {
              hiorlo.setText("LOSER!!!");
              winnerorlosser= true;
              numberofgames = numberofgames + 1;
              numberofgamesplayed.setText("Number of Games Played: "+numberofgames);
              winvsloss.setText("Success " +((100/numberofgames)*won)+"%");
            }
            
            else if(number>num)
              hiorlo.setText("Guess a Lower Number");
            
            else
              hiorlo.setText("Guess a Higher Number");
            
            
            //numofguess  = "Number Of Guesses: " +  counter;
            System.out.println(number);
            
            System.out.println(num);
            System.out.println("Guesses: " + counter);
          }
          
        }
      }
    });
    
    newGame.addActionListener(new ActionListener() {//CLEAR SEARCHED IMAGE LISTENER
      public void actionPerformed(ActionEvent e) { 
        num = (int)(Math.random()*100 + 1);
        number = 0;
        winnerorlosser = false;
        counter = 0 ;
        textInput.setText("");
        numberofguesses.setText("You have guessed 0 times.");
        hiorlo.setText("Guess a Number");
        
        
      }
    });
    
    lives.addActionListener(new ActionListener() {//CLEAR SEARCHED IMAGE LISTENER
      public void actionPerformed(ActionEvent event) { 
        JComboBox lives = (JComboBox)event.getSource();
        String holder2 = String.valueOf(lives.getSelectedItem());
        livesNum = Integer.parseInt(holder2);
        winnerorlosser = false;
        
        System.out.println(livesNum);
        num = (int)(Math.random()*100 + 1);
        number = 0;
        
        counter = 0 ;
        textInput.setText("");
        numberofguesses.setText("You have guessed 0 times.");
        hiorlo.setText("Guess a Number");
      }
    });

    frame.setContentPane(contentPane);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.setLocationByPlatform(true);
    frame.setVisible(true);
    
  }   
    
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable()
                                 {
      @Override
      public void run()
      {
        new GuessingGame();
      }
    });
  }
}