package Base.LandingPage.API;


import Base.LandingPage.Controller.AllDifferentInputParameters;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Configuration
public class RestApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllDifferentInputParameters.class);

    private final int timeoutSeconds = 3600;

    private final int numberOfRetries = 2;

    public ClientHttpRequestFactory getClientHttpRequestFactory() {

        AuthSchemeProvider spnegoProvider = new SPNegoSchemeFactory(true, true); // ?

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeoutSeconds * 1000)
                .setConnectionRequestTimeout(timeoutSeconds * 1000)
                .setSocketTimeout(timeoutSeconds * 1000)
                .build();

        CloseableHttpClient client = HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(numberOfRetries, false))
                .build();

        return new HttpComponentsClientHttpRequestFactory(); // client
    }

    public static  <T> ResponseEntity<T> GET(Class<T> responseType, String url) {
        LOGGER.info("Initiating GET : {} expecting response type {}", url, responseType.getName());
        try {

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
            httpHeaders.add(HttpHeaders.ACCEPT, "application/json");
            httpHeaders.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8)); // ?

            RestTemplate restTemplate = new RestTemplate(); // Here we like pass the

            return restTemplate.exchange(url,
                    HttpMethod.GET,
                    new HttpEntity<>( httpHeaders),
                    responseType);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }


    public static  <T> ResponseEntity<T> POST(Class<T> responseType, String url, Object postData) {
        LOGGER.info("Initiating POST : {} expecting response type {}", url, responseType.getName());
        try {

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
            httpHeaders.add(HttpHeaders.ACCEPT, "application/json");
            httpHeaders.setAcceptCharset(Collections.singletonList(StandardCharsets.UTF_8)); // ?

            RestTemplate restTemplate = new RestTemplate(); // Here we like pass the

            return restTemplate.exchange(url,
                    HttpMethod.POST,
                    new HttpEntity<>(postData, httpHeaders),
                    responseType);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }


}
