package br.com.livro.carros.test;

import java.io.File;

import com.google.api.services.storage.model.StorageObject;

import br.com.livro.carros.util.CloudStorageUtil;

public class CloudStorageUploadTest {

	private static final String BUCKET_NAME = "silken-cabinet-6120";

	public static void main(String[] args) throws Exception {
		CloudStorageUtil cloudStorage = new CloudStorageUtil("Carros Web Services");
		
		// Campo Email address criado no console.
		String accountId = "computeengine@xenon-hawk-176223.iam.gserviceaccount.com";
		
		// Arquivo p12 baixado no console no momento de criar a chave.
		File p12File = new File("keyP12-ac52a463ba16.p12");
		
		// Conecta
		cloudStorage.connect(accountId, p12File);
		
		// Upload
		System.out.println("Fazendo upload...");
		File file = new File("Ferrari_FF.png");
		String contentType = "image/png";
		String storageProjectId = "538880603338";
		StorageObject obj = cloudStorage.upload(BUCKET_NAME, file, contentType, storageProjectId);
		System.out.println("Upload OK, objeto: " + obj.getName());
	}
	
}
