package Orther;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.io.IOException;
import java.io.InputStream;

public class UploadImage {
	public static void uploadImage(String projectId, String bucketName, String objectName, InputStream filePath)
			throws IOException {
		// The ID of your GCP project
		// String projectId = "your-project-id";

		// The ID of your GCS bucket
		// String bucketName = "your-unique-bucket-name";

		// The ID of your GCS object
		// String objectName = "your-object-name";

		// The path to your file to upload
		// String filePath = "path/to/your/file"

		Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
		BlobId blobId = BlobId.of(bucketName, objectName);
		BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image").build();
		// Optional: set a generation-match precondition to avoid potential race
		// conditions and data corruptions. The request returns a 412 error if the
		// preconditions are not met.
		Storage.BlobWriteOption precondition;
		if (storage.get(bucketName, objectName) == null) {
			// For a target object that does not yet exist, set the DoesNotExist
			// precondition.
			// This will cause the request to fail if the object is created before the
			// request runs.
			precondition = Storage.BlobWriteOption.doesNotExist();
		} else {
			// If the destination already exists in your bucket, instead set a
			// generation-match
			// precondition. This will cause the request to fail if the existing object's
			// generation
			// changes before the request runs.
			precondition = Storage.BlobWriteOption.generationMatch(storage.get(bucketName, objectName).getGeneration());
		}

		storage.createFrom(blobInfo,filePath, precondition);

		System.out.println("File " + " uploaded to bucket " + bucketName + " as " + objectName);
	}
}