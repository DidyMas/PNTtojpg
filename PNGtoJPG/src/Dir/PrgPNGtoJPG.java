package Dir;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PrgPNGtoJPG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String path = "C:\\IOS PNG";
		 
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(
                FileSystems.getDefault().getPath(path), Files::isDirectory)) {
            for (Path p : ds) {
        		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(p.toString()))) {
        		    for (Path file: stream) {

        		        //System.out.println(file.toString());
        		        String original = new String(file.toString());  
        		        File oldfile = new File(original);
        		        String nuevo = original.replace(".PNG", ".jpg");  
        		        File newfile = new File(nuevo);
        		        if (oldfile.renameTo(newfile)) {
        		        	System.out.println("cambio de " + oldfile + " por " + newfile );
        		        }
        		        
        		    }
        		} 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Termine el proceso de actualización de imágenes");
	}
}
