/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaapplication2;

import java.io.File;

/**
 *
 * @author chris
 */
public class PathName {
    
    public static String pathFname(){
    
        String path1 = "C:\\temp\\" , path2 ="C:\\temp\\temp1\\" ;
        
        File file1 = new File(path1);
        File file2 = new File(path2);
        
        if(file1.mkdirs())
            System.out.println("Created C:\\temp\\");
        else
            System.out.println("Already exists C:\\temp\\");
        
        if(file2.mkdirs())
            System.out.println("Created C:\\temp\\temp1\\");
        else
            System.out.println("Already Exists C:\\temp\\temp1\\");
        
        return path2;
    }     
        
    
}
