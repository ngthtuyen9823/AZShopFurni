package com.azshop.upload;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.IOException;
import java.nio.file.Paths;

public class UploadImage {
	public static String uploadImage(String projectId, String bucketName, String objectName, String filePath) throws IOException {
		Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
		BlobId blobId = BlobId.of(bucketName, objectName);
		BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image").build();
		Storage.BlobWriteOption precondition;
		
		if (storage.get(bucketName, objectName) == null) {
			precondition = Storage.BlobWriteOption.doesNotExist();
		} else {
			precondition = Storage.BlobWriteOption.generationMatch(storage.get(bucketName, objectName).getGeneration());
		}
		storage.createFrom(blobInfo, Paths.get(filePath), precondition);
		return("File " + filePath + " uploaded to bucket " + bucketName + " as " + objectName);
	}
}
