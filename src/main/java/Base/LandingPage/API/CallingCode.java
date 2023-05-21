package Base.LandingPage.API;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallingCode {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallingCode.class);

    @Autowired
    private RestApi restApi;

    public String getDataFromApi() {
        String url = "https://jsonplaceholder.typicode.com/todos/1";

        // Initiating GET request
        String getRequestResult = String.valueOf(restApi.GET(String.class, url).getBody());

        // Initiating POST request
        String reqObj = "Dummy Data";
        // String postRequestResult = String.valueOf(restApi.POST(String.class, url, reqObj).getBody()); // Response, Url, RequestObject

        return  getRequestResult;
    }

}
