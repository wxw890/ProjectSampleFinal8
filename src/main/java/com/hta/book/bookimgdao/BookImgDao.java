package com.hta.book.bookimgdao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class BookImgDao {
private FileOutputStream fout;
	
	public void writeFile(MultipartFile file, String path, String filename) throws IOException{
		try{
			byte fileData[] = file.getBytes();
			fout = new FileOutputStream(path + File.separator + filename);
			fout.write(fileData);
		}
		catch(IOException err){
			err.printStackTrace();
		}
		finally{
			fout.close();
		}
	}
}
