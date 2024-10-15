/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producing;

/**
 *
 * @author Andrea
 */
public class Suoni {
    static String kickPath, snarePath, clapPath, hatPath, ateoatePath, samplePath, percPath;
    public Suoni(){
        // path default dei suoni
        Suoni.kickPath = "kicks/kick.wav";
        Suoni.snarePath = "snares/snare.wav";
        Suoni.clapPath = "claps/clap.wav";
        Suoni.hatPath = "hats/hat.wav";
        Suoni.ateoatePath = "808s/808.wav";
        Suoni.samplePath = "samples/sample.wav";
        Suoni.percPath = "percs/perc.wav";
    }
    // metodi per restituire la path dei suoni
    public String getKickPath(){
        return kickPath;
    }
    public String getSnarePath(){
        return snarePath;
    }
    public String getClapPath(){
        return clapPath;
    }
    public String getHatPath(){
        return hatPath;
    }
    public String getAteOAtePath(){
        return ateoatePath;
    }
    public String getSamplePath(){
        return samplePath;
    }
    public String getPercPath(){
        return percPath;
    }
    
    // metodi per modificare la path dei suoni
    public void setKickPath(String newPath){
        kickPath = newPath;
    }
    public void setSnarePath(String newPath){
        snarePath = newPath;
    }
    public void setClapPath(String newPath){
        clapPath = newPath;
    }
    public void setHatPath(String newPath){
        hatPath = newPath;
    }
    public void setAteOAtePath(String newPath){
        ateoatePath = newPath;
    }
    public void setSamplePath(String newPath){
        samplePath = newPath;
    }
    public void setPercPath(String newPath){
        percPath = newPath;
    }
}
