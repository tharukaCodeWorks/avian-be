package lk.teachmeit.boilerplate.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class S3HelperService {
    @Value("${app.aws.iam.accesskey}")
    private String accessKey;

    @Value("${app.aws.iam.secretkey}")
    private String secretKey;

    @Value("${app.aws.s3.clientregion}")
    private String clientRegion;

    @Value("${app.aws.s3.bucketname}")
    private String bucketName;

    @Value("${spring.servlet.multipart.max-file-size}")
    private Integer maxFileSize;

    public String uploadImage(MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        String[] extention = file.getOriginalFilename().split("\\.");
        String objectName = RandomStringUtils.randomAlphabetic(20)+"."+extention[extention.length-1];

        if (file.getSize() > maxFileSize) {
            //  throw new InvalidFileSizeException();
            throw new Exception();
        } else {

            BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
            AmazonS3ClientBuilder s3ClientBuilder = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds));


            AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration("ewr1.vultrobjects.com", clientRegion);
            s3ClientBuilder.setEndpointConfiguration(endpointConfiguration );
            AmazonS3 s3Client = s3ClientBuilder.build();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            // metadata.addUserMetadata("x-amz-meta-title", "someTitle");
            metadata.setContentLength(file.getSize());

            InputStream inputStream = new ByteArrayInputStream(bytes);
            PutObjectRequest request = new PutObjectRequest(bucketName, objectName, inputStream, metadata);

            AccessControlList accessControlList = new AccessControlList();
            accessControlList.grantPermission(GroupGrantee.AllUsers, Permission.Read);
            request.setAccessControlList(accessControlList);

            s3Client.putObject(request);

            return "https://"+bucketName+"."+clientRegion+".amazonaws.com" + "/" + objectName;
        }
    }

    public void deleteFile(String fileLink){

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey, secretKey);
        @SuppressWarnings("rawtypes")
        AmazonS3ClientBuilder s3ClientBuilder = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds));

        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration("ewr1.vultrobjects.com", clientRegion);
        s3ClientBuilder.setEndpointConfiguration(endpointConfiguration );
        AmazonS3 s3Client = s3ClientBuilder.build();
        final DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName, fileLink);
        s3Client.deleteObject(deleteObjectRequest);
    }
}
