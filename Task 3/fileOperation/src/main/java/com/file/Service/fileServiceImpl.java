package com.file.Service;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.Source.fileSource;
import com.file.model.filePaths;

@Service
public class fileServiceImpl implements fileService {

	@Autowired
	private fileSource fs;
	
	@Override
	public void fileSafeTransfer(filePaths path) {
		
		File plaintext = new File(path.getSourcePath()+"\\"+path.getFileName());
		File encrypted = new File(path.getSourcePath()+"\\encrypted.txt");
		File decrypted = new File(path.getDestinationPath()+"\\decrypted.txt");
		
		try {
			fs.encryptDecrypt("12345678", Cipher.ENCRYPT_MODE, plaintext, encrypted);
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fs.encryptDecrypt("12345678", Cipher.DECRYPT_MODE, encrypted, decrypted);
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	 

}
