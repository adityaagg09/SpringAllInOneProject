package Base.LandingPage.API;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CallingCode {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallingCode.class);

    @Autowired
    private RestApi restApi;

    @Transactional // If transaction is not completed it will revoked all the db inserts
    public String getDataFromApi() {
        String url = "https://jsonplaceholder.typicode.com/todos/1";


        // Creating url with map received from ui for different url params
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Test", "Test2");
        map.add("Test", "Test3");
        map.add("Test1", "Test2");
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url).queryParams(map).build();
        String urlFromUriComponents = uriComponents.toUriString();

        // Initiating GET request
        String getRequestResult = String.valueOf(restApi.GET(String.class, url).getBody());

        // Initiating POST request
        String reqObj = "Dummy Data";
        // String postRequestResult = String.valueOf(restApi.POST(String.class, url, reqObj).getBody()); // Response, Url, RequestObject

        return  getRequestResult;
    }

}
