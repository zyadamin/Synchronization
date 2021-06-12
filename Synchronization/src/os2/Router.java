/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author zezo
 */
public class Router {
    static ArrayList<Integer>connections= new ArrayList<>();
    static  int maxDevices;
    static  Semaphore handelConnection;

    public Router(Semaphore handel,int Max) {
        Router.handelConnection=handel;
        Router.maxDevices=Max;
      for(int i=1;i<=maxDevices;i++){
        
        connections.add(i);
        }
        
    }
   

    
    public static  int  startConnection(Device newDevice) throws IOException {
        if(maxDevices>0){OS2.writer.write(newDevice.getMyName()+" arrived\n");}
        else {OS2.writer.write(newDevice.getMyName()+" arrived and wating \n");}
            maxDevices--; 
        
        
        handelConnection.P();

        
      int x=connections.get(0);
      connections.remove(0);

return  x;
        }
        
    
    
    
        
    public static  void endConnection(int x) {
         maxDevices++;
        connections.add(x);
      handelConnection.V();
        
    }
   
    
    
    
}
