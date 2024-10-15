/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.sound.sampled.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Andrea
 */
public class Home extends JFrame implements ActionListener{
    JButton kickButton, hatButton, snareButton, clapButton, ateoateButton, percButton; // bottoni che riproducono i suoni
    JButton sampleButton; //
    Menu menu; //
    static Clip clip;
    static AudioInputStream audioInputStream;
    /**
     *
     * @param soundName : La path in cui si trova il suono
     * Questo metodo ha il compito di riprodurre un suono utilizzando AudioInputStream
     */
    public void playSound(String soundName){
      try 
      {
       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
       Clip clip = AudioSystem.getClip();
       clip.open(audioInputStream);
       clip.start();
      }
      catch(Exception ex)
      {
        ex.printStackTrace( );
      }
    }
    /**
     *
     * @param soundName
     * @param loop
     * Questo metodo ha il compito di riprodurre un suono utilizzando AudioInputStream in modalità loop
     */
    public void playSound(String soundName, boolean loop){
      try 
      {
       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
       Clip clip = AudioSystem.getClip();
       clip.open(audioInputStream);
       clip.start();
       if(loop) clip.loop(200);
      }
      catch(Exception ex)
      {
        ex.printStackTrace( );
      }
    } 
    public void playSound(String soundName, boolean loop, int n){ // n = numero di volte in cui viene riprodotto il suono
      try 
      {
       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
       Clip clip = AudioSystem.getClip();
       clip.open(audioInputStream);
       clip.start();
       if(loop) clip.loop(n);
      }
      catch(Exception ex)
      {
        ex.printStackTrace( );
      }
    }
    Suoni suoni;
    public Home() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        suoni = new Suoni();
        menu = new Menu();
        this.setJMenuBar(menu);
        
        kickButton = new JButton("KICK");
        
        kickButton.addActionListener(this);
        
        hatButton = new JButton("HAT");
        
        hatButton.addActionListener(this);
        
        snareButton = new JButton("SNARE");
        
        snareButton.addActionListener(this);
        
        clapButton = new JButton("CLAP");
        
        clapButton.addActionListener(this);
        
        ateoateButton = new JButton("808");
        ateoateButton.addActionListener(this);
        
        percButton = new JButton("PERC");
        percButton.addActionListener(this);
        
        Vector<JButton> jbuttons = new Vector();
        jbuttons.add(hatButton);
        jbuttons.add(kickButton);
        jbuttons.add(ateoateButton);
        jbuttons.add(clapButton);
        jbuttons.add(snareButton);
        jbuttons.add(percButton);
        JPanel buttonsPanel = new JPanel();
        
        
        ImageIcon icon = new ImageIcon(new ImageIcon("button.png").getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_DEFAULT));
        for(JButton b : jbuttons){
            b.setBorder(null);
            b.setOpaque(false);
            b.setBackground(Color.GRAY);
            b.setIcon(icon);
            b.setHorizontalTextPosition(JButton.LEFT);
            b.setVerticalTextPosition(JButton.TOP);
            b.setFocusable(false);
            b.setForeground(Color.decode("#b20e0c"));
            b.setFont(new Font("Helvetica",Font.BOLD, 15 ));
            b.setBorderPainted(false);
        }
        buttonsPanel.setLayout(new GridLayout(3,2));
        buttonsPanel.setPreferredSize(new Dimension(500,500));
        buttonsPanel.setBackground(Color.decode("#9BA096"));
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        
        buttonsPanel.add(ateoateButton);      
        buttonsPanel.add(kickButton);
        buttonsPanel.add(hatButton);
        buttonsPanel.add(snareButton);
        buttonsPanel.add(clapButton);
        buttonsPanel.add(percButton);
        buttonsPanel.setBorder(BorderFactory.createEtchedBorder());
        JPanel logopanel = new JPanel();
        JLabel logo = new JLabel(new ImageIcon("logo.png"));
        logo.setAlignmentX(JLabel.RIGHT);
        logo.setAlignmentY(JLabel.CENTER);
        logopanel.add(logo);
        logopanel.setLayout(new BoxLayout(logopanel,  BoxLayout.PAGE_AXIS));
        logopanel.setBackground(Color.decode("#DBDDCD"));
        sampleButton = new JButton("SAMPLE");
        sampleButton.setFocusable(false);
        sampleButton.setBackground(Color.LIGHT_GRAY);
        sampleButton.setBounds(new Rectangle(10,10));
        
        sampleButton.addActionListener(this);
        
        logopanel.add(sampleButton);
        logopanel.add(buttonsPanel);
        

        this.setBackground(Color.decode("#DBDDCD"));
        this.add(logopanel);
        //this.add(buttonsPanel);
        this.pack();
        try 
      {
       audioInputStream = AudioSystem.getAudioInputStream(new File(suoni.getSamplePath()).getAbsoluteFile());
       clip = AudioSystem.getClip();
       clip.open(audioInputStream);
       
      }
      catch(Exception ex)
      {
        ex.printStackTrace( );
      }

        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // al click dei bottoni si riproduce il suono dalla path selezionata
        if(e.getSource() == kickButton){
            
            playSound(suoni.getKickPath());
        }
        if(e.getSource() == hatButton){
            
            playSound(suoni.getHatPath(), menu.getLoopHatValue());
        }
        if(e.getSource() == snareButton){
            
            playSound(suoni.getSnarePath());

        }
        if(e.getSource() == clapButton){
            playSound(suoni.getClapPath());
        }
        if(e.getSource() == ateoateButton){
            playSound(suoni.getAteOAtePath());
        }
        if(e.getSource() == percButton){
            playSound(suoni.getPercPath());
        }
        if(e.getSource()==sampleButton){ // permette di stoppare il loop del sample
            System.out.println(suoni.getSamplePath());
            if(!clip.isRunning()){
                clip.setMicrosecondPosition(0);
                if(menu.getLoopSampleValue()) clip.loop(-1);
                clip.start();
                
            } else {
                clip.stop();
                clip.flush();
                clip.setMicrosecondPosition(0);
            }
        }
    }
}