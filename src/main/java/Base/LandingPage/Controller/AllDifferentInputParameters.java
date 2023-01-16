package Base.LandingPage.Controller;

import Base.LandingPage.Model.AllDifferentInputParamters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllDifferentInputParameters {

    @GetMapping(value = "/getMappingParam")
    public void getMappingParamString(@RequestBody String requestBodyParam) {
        // When ip data is string only
        System.out.println("Request Body parameters are : " +  (requestBodyParam));
    }

//    @GetMapping(value = "/getMappingParam")
//    public void getMappingParamJson(@RequestBody AllDifferentInputParamters requestBodyParam) {
//        // When ip data is string only
//        System.out.println("Request Body parameters are : " +  (requestBodyParam));
//    }


}
