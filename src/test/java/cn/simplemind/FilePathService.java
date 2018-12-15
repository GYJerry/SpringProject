package cn.simplemind;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author yingdui_wu
 * @date   2018年10月16日 下午8:01:27
 */
@Service
public class FilePathService {
    
    @Test
    public void printFilePath() {
        System.out.println("FilePathService.class.getResource(\"\"):");
        System.out.println(FilePathService.class.getResource("").toString());
        
        System.out.println("FilePathService.class.getResource(\"/\"):");
        System.out.println(FilePathService.class.getResource("/"));
        
        System.out.println("Thread.currentThread().getContextClassLoader().getResource(\"\"):");
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        
        System.out.println("FilePathService.class.getClassLoader().getResource(\"\"):");
        System.out.println(FilePathService.class.getClassLoader().getResource(""));
        
        System.out.println("ClassLoader.getSystemResource(\"\"):");
        System.out.println(ClassLoader.getSystemResource(""));
        
        File file = new File("classpath:warningInfo.properties");
        System.out.println(file.getPath());
        FileInputStream in;
        try {
            in = new FileInputStream(file);
        
            int tempbyte;  
            while ((tempbyte = in.read()) != -1) {  
                System.out.write(tempbyte);  
            }  
            in.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}
