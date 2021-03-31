package exception.compile.test;
//. try~catch  2.throws
import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading2{
	public void readFile(String filename) throws FileNotFoundException {
	
			FileReader fr = new FileReader(filename);
			System.out.println("..new FileReader()...filename...");
		
		System.out.println("FileReader Creating....");
	}
}

public class CompileExceptionTest2 {

	public static void main(String[] args) {
		
	 FileReading2 f = new FileReading2();
	 String path = "C:\\encore_KSJ\\util\\poem.txt";
	 try {
	 f.readFile(path); {
		 
	 }
	 }catch(FileNotFoundException e) {
	 
	 }
	 System.out.println("파일을 잘 읽어들였습니다....");
	
	}
}
