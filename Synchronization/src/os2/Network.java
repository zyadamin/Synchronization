/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zezo
 */
public class Network {
    
    ArrayList<Device>devices= new ArrayList<>();
    
    public void buildConnection() throws IOException, InterruptedException{
    
        Scanner input= new Scanner(System.in);
    
    int maxConnection,connections;
    System.out.println("What is number of WI-FI Connections? ");   
    maxConnection=input.nextInt();
    
    System.out.println("What is number of devices Clients want to connect? ");
    connections=input.nextInt();
   
    Semaphore c= new Semaphore(maxConnection); 
    Router myRouter= new Router(c,maxConnection);
    
        for (int i = 0; i < connections; i++) {
            
            String name,type;
            name= input.next();
            type= input.next();
            
            Device newOne= new Device(name,type);
            devices.add(newOne);
            
           
        }
            Random random= new Random();

            for(int i=0;i<devices.size();i++){
    

            try {
               Thread.sleep(random.nextInt(500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Router.class.getName()).log(Level.SEVERE, null, ex);
            }
           devices.get(i).start();

          }
           for(int i=0;i<devices.size();i++){

         devices.get(i).join();

           }

    }
    
    
    
    
}
