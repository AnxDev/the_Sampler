/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import static producing.Home.audioInputStream;

/**
 *
 * @author Andrea
 */
public class Menu extends JMenuBar implements ActionListener{
    Suoni suoni;
    JCheckBoxMenuItem loopSample, loopHat;
    JMenuItem setKick, setHat, setSnare, setClap, setSample, setPerc, setAteoate;
    public Menu(){
        suoni = new Suoni();
        
        JMenu optionMenu = new JMenu("Opzioni");
        loopSample = new JCheckBoxMenuItem("loop sample");
        loopHat = new JCheckBoxMenuItem("loop hat");
        
        JMenu suoniMenu = new JMenu("Suoni");
        
        setKick = new JMenuItem("Cambia kick");
        setHat = new JMenuItem("Cambia hat");
        setSnare = new JMenuItem("Cambia snare");
        setClap = new JMenuItem("Cambia clap");
        setSample = new JMenuItem("Cambia sample");
        setPerc = new JMenuItem("Cambia perc");
        setAteoate = new JMenuItem("Cambia 808");
        
        Vector<JMenuItem> sounds = new Vector();
        sounds.add(setKick);
        sounds.add(setHat);
        sounds.add(setSnare);
        sounds.add(setClap);
        sounds.add(setPerc);
        sounds.add(setAteoate);
        sounds.add(setSample);
        
        for(JMenuItem sound : sounds){
            sound.addActionListener(this);
            suoniMenu.add(sound);
        }
        
        
        optionMenu.add(loopSample);
        optionMenu.add(loopHat);
        
        this.add(optionMenu);
        this.add(suoniMenu);
    }
    // Metodo che chiede all'utente la path del nuovo suono
    private String getFilePath(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Wave files", "wav");
        fileChooser.addChoosableFileFilter(filter);
        int response = fileChooser.showOpenDialog(null);
        if(response == JFileChooser.APPROVE_OPTION){
            String filepath = new File(fileChooser.getSelectedFile().getAbsolutePath()).toString();
            return filepath;
        }
        return "";
    } 
    // Questi due metodi restituiscono il valore delle checkbox che permettono di decidere se loopare il sample o l'hat
    public boolean getLoopSampleValue(){
        return loopSample.getState();
    }
    public boolean getLoopHatValue(){
        return loopHat.getState();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // modificano la path dei suoni
        if(e.getSource() == setKick) {
            String path = getFilePath();
            
            if(!path.isEmpty()) suoni.setKickPath(path);
             
        }
        if(e.getSource() == setAteoate) {
            String path = getFilePath();
            
            if(!path.isEmpty()) suoni.setAteOAtePath(path);
             
        }
        if(e.getSource() == setClap) {
            String path = getFilePath();
            
            if(!path.isEmpty()) suoni.setClapPath(path);
             
        }
        if(e.getSource() == setHat) {
            String path = getFilePath();
            
            if(!path.isEmpty()) suoni.setHatPath(path);
             
        }
        if(e.getSource() == setPerc) {
            String path = getFilePath();
            
            if(!path.isEmpty()) suoni.setPercPath(path);
             
        }
        if(e.getSource() == setSample) {
            String path = getFilePath();
            
            if(!path.isEmpty()) {
                suoni.setSamplePath(path);
                try {
                    Home.audioInputStream = AudioSystem.getAudioInputStream(new File(suoni.getSamplePath()).getAbsoluteFile()); // serve per aggiornare la path del sample
                    Home.clip.close();
                    Home.clip.open(Home.audioInputStream);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);

                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             
        }
        if(e.getSource() == setSnare) {
            String path = getFilePath();
            
            if(!path.isEmpty()) suoni.setSnarePath(path);
             
        }

        
    }
   
}
