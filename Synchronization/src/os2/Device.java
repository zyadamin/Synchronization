package os2;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zezo
 */
public class Device extends Thread  {
 
    Random random= new Random();
    int connect;
    String name;
    String type;

    public Device(String name, String type) throws IOException {
        this.name = name;
        this.type = type;

    }

    
    
    @Override
    public void run() {

        try {
            this.connect();
        } catch (IOException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
        try {
            this.perform();
        } catch (IOException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.loguot();
        } catch (IOException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    
    public void connect() throws IOException{
        
       connect= Router.startConnection(this);

        OS2.writer.write("connection "+connect+"  "+name+" Occupied\n");
        try {
            Thread.sleep(random.nextInt(1500));
        } catch (InterruptedException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
        public void perform () throws IOException{

        OS2.writer.write("connection "+connect+"  "+name+" performs online activity\n");
    
        try {
            Thread.sleep(random.nextInt(1500));
        } catch (InterruptedException ex) {
            Logger.getLogger(Device.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
        
        public void loguot () throws IOException{
          
        OS2.writer.write("connection "+connect+"  "+name+" Logged out\n");
            
     
        
        Router.endConnection(connect);
    }    

    
    public String getMyName() {
        return name;
    }
 
        
}
