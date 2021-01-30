package xo_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Game_Window {
    
    //Variables
    JFrame frame;
    JPanel game_panel;
    JLabel TIMER_LABEL,TURN_LABEL,RESULT_LABEL;
    static JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,start_btn,play_again_btn;
    Timer timer;
    Icon x_ico;
    Icon o_ico;
    short checkBtn = 1;
    short scount = 10;
    boolean startBtnIsOn = false;
    boolean[] btnFlag = new boolean[]{false,false,false,false,false,false,false,false,false};
    boolean[][] xOro = new boolean[][]{{false,false,false},{false,false,false},{false,false,false}};
    
    
    
    
    
    
    //Constructor
    public Game_Window(){
        //RESULT_LABEL Declaration
        RESULT_LABEL = new JLabel("Sorry! time is over");
        RESULT_LABEL.setBounds(193, 450, 500, 50);
        RESULT_LABEL.setFont(new Font("Serif", Font.BOLD, 15));
        RESULT_LABEL.setForeground(Color.RED);
        RESULT_LABEL.setVisible(false);
        
        //count down timer Declaration 
        TIMER_LABEL = new JLabel("00:00");
        TIMER_LABEL.setBounds(20, 5, 50, 50);
        TIMER_LABEL.setFont(new Font("Serif", Font.BOLD, 20));
        
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                scount--;
                if(scount>0){
                    TIMER_LABEL.setText("00:"+scount);     
                }
                if(scount == 5){
                    TIMER_LABEL.setForeground(Color.RED);
                }
                if(scount == 0){
                    TIMER_LABEL.setText("00:00");
                    timer.stop();
                    RESULT_LABEL.setVisible(true);
                    disableBtns();  
                }
            }
        });
        
        //TURN LABEL DECLARATION
        TURN_LABEL = new JLabel("Press start to play");
        TURN_LABEL.setBounds(193, 55, 500, 50);
        TURN_LABEL.setFont(new Font("Serif", Font.BOLD, 15));
        
        //Game buttons icons Declarations
        x_ico = new ImageIcon("E:\\Java Projects\\XO_Game\\X_ico.png", "x");
        o_ico = new ImageIcon("E:\\Java Projects\\XO_Game\\O_ico.png", "o");
        
        
        //Buttons
        btn1 = new JButton();
        btn1.setFocusable(false);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (startBtnIsOn && !btnFlag[0]) {
                    btnClick(btn1);
                    btnFlag[0] = true;
                    xOro[0][0] = checkBtn % 2 == 0 ;
                    checkWinnerX();    
                }
            }
        });
           
       

        btn2 = new JButton();
        btn2.setFocusable(false);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(startBtnIsOn && !btnFlag[1]){
                btnClick(btn2);
                btnFlag[1] = true;
                xOro[0][1] = checkBtn % 2 == 0;
                checkWinnerX();
                }
            }
        });
        
        btn3 = new JButton();
        btn3.setFocusable(false);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(startBtnIsOn && !btnFlag[2]){
                btnClick(btn3);
                btnFlag[2] = true;             
                xOro[0][2] = checkBtn % 2 == 0;
                checkWinnerX();
                }
            }
        });
        
        btn4 = new JButton();
        btn4.setFocusable(false);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(startBtnIsOn && !btnFlag[3]){
                btnClick(btn4);
                btnFlag[3] = true;
                xOro[1][0] = checkBtn % 2 == 0;
                checkWinnerX();
                }
            }
        });
        
        btn5 = new JButton();
        btn5.setFocusable(false);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(startBtnIsOn && !btnFlag[4]){
                btnClick(btn5);
                btnFlag[4] = true;
                
                xOro[1][1] = checkBtn % 2 == 0;
                checkWinnerX();
                }
            }
        });
        
        btn6 = new JButton();
        btn6.setFocusable(false);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(startBtnIsOn && !btnFlag[5]){
                btnClick(btn6);
                btnFlag[5] = true;
                
                xOro[1][2] = checkBtn % 2 == 0;
                checkWinnerX();
                }
            }
        });
        
        btn7 = new JButton();
        btn7.setFocusable(false);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(startBtnIsOn && !btnFlag[6]){
                btnClick(btn7);
                btnFlag[6] = true;
                xOro[2][0] = checkBtn % 2 == 0;
                checkWinnerX();
                }
            }
        });
        
        btn8 = new JButton();
        btn8.setFocusable(false);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(startBtnIsOn && !btnFlag[7]){
                btnClick(btn8);
                btnFlag[7] = true;               
                xOro[2][1] = checkBtn % 2 == 0;
                checkWinnerX();

                }
            }
        });
        
        btn9 = new JButton();
        btn9.setFocusable(false);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(startBtnIsOn && !btnFlag[8]){
                btnClick(btn9);
                btnFlag[8] = true;
                xOro[2][2] = checkBtn % 2 == 0;
                checkWinnerX();

                }
            }
        });
        
        start_btn = new JButton("Start");
        start_btn.setFont(new Font("Serif", Font.BOLD, 16));
        start_btn.setFocusable(false);
        start_btn.setBounds(200, 20, 100, 50);
        start_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                timer.start();
                startBtnIsOn = true;
                TURN_LABEL.setText("X's Turn");
                TURN_LABEL.setBounds(220, 55, 500, 50);
                
            }
        });
        
        play_again_btn = new JButton("Play again");
        play_again_btn.setFont(new Font("Serif", Font.BOLD, 15));
        play_again_btn.setFocusable(false);
        play_again_btn.setBounds(370, 500, 100, 50);
        play_again_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                Game_Window gameStart1 = new Game_Window();
            }
        });
        
        
        //Game_panel
        game_panel = new JPanel();
        game_panel.setLayout(new GridLayout(3, 3));
        game_panel.setBounds(100, 100, 300, 300);
        
        //panel buttons
        game_panel.add(btn1);
        game_panel.add(btn2);
        game_panel.add(btn3);
        game_panel.add(btn4);
        game_panel.add(btn5);
        game_panel.add(btn6);
        game_panel.add(btn7);
        game_panel.add(btn8);
        game_panel.add(btn9);
        
        
        
        //frame
        frame = new JFrame("XO");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setBounds(400, 50, 500, 600);
        frame.setResizable(false);
        frame.add(game_panel);
        frame.add(start_btn);
        frame.add(play_again_btn);
        frame.add(TIMER_LABEL);
        frame.add(TURN_LABEL);
        frame.add(RESULT_LABEL);
        frame.setVisible(true);
       
        
     
    }
    
    public void btnClick(JButton btn)
    {
        if(checkBtn%2==0){
            btn.setIcon(o_ico);
            TURN_LABEL.setText("X's Turn");
        }
        else{
            btn.setIcon(x_ico);
            TURN_LABEL.setText("O's Turn");
        }
        checkBtn++;
    }
    
    private void checkWinnerX()
    {
        String winner_letter;
        
        if ((xOro[0][0] && xOro[1][0] && xOro[2][0])) {
            winner_letter = "X";
            result_Action(winner_letter);
        }
        if ((xOro[0][1]&&xOro[1][1]&&xOro[2][1])) {
            winner_letter = "X";
            result_Action(winner_letter);
        }
        if ((xOro[0][2]&&xOro[1][2]&&xOro[2][2])) {
            winner_letter = "X";
            result_Action(winner_letter);
        }
        if ((xOro[0][0]&&xOro[0][1]&&xOro[0][2])) {
            winner_letter = "X";
            result_Action(winner_letter);
        }
        if ((xOro[1][0]&&xOro[1][1]&&xOro[1][2])) {
            winner_letter = "X";
            result_Action(winner_letter);
        }
        if ((xOro[2][0]&&xOro[2][1]&&xOro[2][2])) {
            winner_letter = "X";
            result_Action(winner_letter);
        }
        if ((xOro[0][0]&&xOro[1][1]&&xOro[2][2])) {
           winner_letter = "X";
            result_Action(winner_letter);
        }
        if ((xOro[0][2]&&xOro[1][1]&&xOro[2][0])) {
            winner_letter = "X";
            result_Action(winner_letter);
        }
        
    }
   
    
    
    private void disableBtns(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }
    private void result_Action(String winner_letter){
        
        RESULT_LABEL.setText(winner_letter + " is winner!");
        RESULT_LABEL.setForeground(Color.BLUE);
        RESULT_LABEL.setVisible(true);
        TURN_LABEL.setVisible(false);
        timer.stop();
        disableBtns();

    }
            
    
}
