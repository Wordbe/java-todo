package co.whitetree.javatodo.support.aws;

import co.whitetree.javatodo.support.utils.LocalDateTimeUtils;
import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class S3Client {
    private static final String BUCKET = "mars-images1";
    private static final int PRESIGNED_GET_URL_EXPIRATION_DAYS = 1;
    private static final int PRESIGNED_POST_URL_EXPIRATION_MINUTES = 5;

    private final AmazonS3 amazonS3;

    public S3Client(AwsS3Property awsS3Property) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(awsS3Property.accessKey(), awsS3Property.secretKey());
        this.amazonS3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_NORTHEAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    public String getImageUrl(String filename, LocalDateTime requestAt) {
        Date expiredAt = LocalDateTimeUtils.toDate(requestAt.plusDays(PRESIGNED_GET_URL_EXPIRATION_DAYS));
        return presignedUrl(filename, expiredAt, HttpMethod.GET);
    }

    private String presignedUrl(String filename, Date expiredAt, HttpMethod httpMethod) {
        return amazonS3.generatePresignedUrl(BUCKET, filename, expiredAt, httpMethod).toString();
    }
}
