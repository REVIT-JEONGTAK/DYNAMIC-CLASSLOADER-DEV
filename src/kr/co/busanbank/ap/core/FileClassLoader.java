package kr.co.busanbank.ap.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileClassLoader extends ClassLoader {

	private String root;
	
	public FileClassLoader(String rootDir) throws FileNotFoundException {
		
		super(FileClassLoader.class.getClassLoader());
		
		File file = new File(rootDir);
		System.out.println("rootpath :: " + file.getPath());
		if ( file.isDirectory() ) {
			root = rootDir;
		} else {
			throw new FileNotFoundException(rootDir + " isn't a directory");
		}
	}
	
	public Class findClass(String name) throws ClassNotFoundException {
		
		String path = root + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
		System.out.println("path :: " + path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			byte[] classByte = new byte[fis.available()];
			fis.read(classByte);
			return defineClass(name, classByte, 0, classByte.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if ( fis != null )
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		System.out.println("class is null");
		return null;
	}
}
