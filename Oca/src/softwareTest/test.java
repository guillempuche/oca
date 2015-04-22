/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softwareTest;
import java.util.*;

public class test {
   public static void main(String args[]) {
      // create hash map
      HashMap newmap = new HashMap();
      
      // populate hash map
      newmap.put(1, "tutorials");
      newmap.put(2, "point");
      newmap.put(3, "is best");
      
      // get keyset value from map
      Set keyset=newmap.keySet();
      
      // check key set values
      System.out.println("Key set values are: " + keyset);
   }    
}