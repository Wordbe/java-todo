package co.whitetree.javatodo.support.aws;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("aws.s3")
@Setter
public class AwsS3Property {
    private String accessKey;
    private String secretKey;

    public String accessKey() {
        return accessKey;
    }

    public String secretKey() {
        return secretKey;
    }
}
