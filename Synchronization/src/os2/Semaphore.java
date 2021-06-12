package os2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zezo
 */
public class Semaphore {
    protected int value = 0 ;
protected Semaphore() { value = 0 ; }

protected Semaphore(int initial) { value = initial ; }

public synchronized boolean P() {
value-- ;
if (value < 0){
    
try { wait() ; } catch( InterruptedException e ) { }
return true;
}
return false;
}
public synchronized void V() {
value++ ; if (value <= 0) notify() ;
}

    public int getValue() {
        return value;
    }
    



}
