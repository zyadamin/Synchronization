/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2;

import java.io.FileWriter;
import java.io.IOException;
import static os2.OS2.writer;

/**
 *
 * @author zezo
 */
public class OS2 {
     
    
    static FileWriter writer;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
       
        writer = new FileWriter("log.txt");

        Network myNetwork= new Network();
        
        myNetwork.buildConnection();
        
          writer.close();



    }

    
}
