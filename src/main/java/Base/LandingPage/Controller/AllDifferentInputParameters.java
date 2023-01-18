package Base.LandingPage.Controller;

import Base.LandingPage.Model.AllDifferentInputParamters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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
        LOGGER.info("Request Body parameters are : {}", requestBodyParam.toString());
    }


    @GetMapping(value = "/getMappingParamListJson")
    public void getMappingParamListJson(@RequestBody List<AllDifferentInputParamters> requestBodyParam) {
        // When ip data is list send data like this [{"firtName":"","lastName":""}, {"firtName":"","lastName":""}]
        LOGGER.info("Request Body parameters are : {}", requestBodyParam.toString());
    }

    @PostMapping(value = "/postMappingParamSingleValue")
    public void postMappingParam(@RequestParam(name = "id") String val) {
        // We are sending the id from above and mapping it to the val
        LOGGER.info("Request Body parameters are : {}", val);
    }

    @PostMapping(value = "/postMappingParamSingleValueWithMultipleValues")
    public void postMappingParamWithMultipleValuesOfSameColumn(@RequestParam(name = "id") List<String> val) {
        // We are sending the id with multiple values into it
        LOGGER.info("Request Body parameters are : {},  {}", val.size(), val.toString());
    }

    @PostMapping(value = "/postMappingParamSingleValueWithMultipleKeyValue")
    public void postMappingParamWithMultipleKeyValue(@RequestParam Map<String, String> val) {
        // We are sending the id with multiple values into it
        LOGGER.info("Request Body parameters are : {},  {}", val.size(), val.toString());
    }

}
