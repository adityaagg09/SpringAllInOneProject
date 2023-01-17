package Base.LandingPage.Controller;

import Base.LandingPage.Model.AllDifferentInputParamters;
import Base.LandingPage.Scheduler.Scheduler;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

import java.util.List;


@RestController
public class AllDifferentInputParameters {

    private static final Logger LOGGER =  LoggerFactory.getLogger(AllDifferentInputParameters.class);


    @GetMapping(value = "/getMappingParamString")
    public void getMappingParamString(@RequestBody String requestBodyParam) {
        // When ip data is string only
        LOGGER.info("Request Body parameters are : {}",requestBodyParam);
    }

    @GetMapping(value = "/getMappingParamJson")
    public void getMappingParamJson(@RequestBody AllDifferentInputParamters requestBodyParam) {
        // When ip data is string only
        LOGGER.info("Request Body parameters are : {}",requestBodyParam.toString());
    }


    @GetMapping(value = "/getMappingParamListJson")
    public void getMappingParamListJson(@RequestBody List<AllDifferentInputParamters> requestBodyParam) {
        // When ip data is list send data like this [{"firtName":"","lastName":""}, {"firtName":"","lastName":""}]
        LOGGER.info("Request Body parameters are : {}",requestBodyParam.toString());
    }

//    @GetMapping(value = "/getMappingParamListJson")
//    public void getMappingParam(@ List<AllDifferentInputParamters> requestBodyParam) {
//        // When ip data is list send data like this [{"firtName":"","lastName":""}, {"firtName":"","lastName":""}]
//        LOGGER.info("Request Body parameters are : {}",requestBodyParam.toString());
//    }


}
