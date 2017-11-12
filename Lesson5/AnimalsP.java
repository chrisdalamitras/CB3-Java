/*
 * Display all animals except the ones starting with the letter p
 */
package animalsp;


/**
 *
 * @author chris
 */
public class AnimalsP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] animals = {"cat", "dog", "pig", "bird", "parrot", "rabbit"};
        
        System.out.println("Printing animals using charAt() method");
        for(String animal:animals){
            if(animal.charAt(0) != 'p')
                System.out.print(animal+"\t");         
        }
        
        System.out.println();
        System.out.println("Printing animals using startsWith() method");
        for(String animal:animals){
            if(!animal.startsWith("p"))
                System.out.print(animal+"\t");         
        }
        
        System.out.println();
        System.out.println("Printing animals using substring() method");
        for(String animal:animals){
            if(!animal.substring(0, 1).equals("p"))
               System.out.print(animal+"\t");         
        }
        System.out.println();
    }
   
}
