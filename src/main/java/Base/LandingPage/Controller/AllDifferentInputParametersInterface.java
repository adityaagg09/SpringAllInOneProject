package Base.LandingPage.Controller;

import Base.Exception.MakeYourOwnException;
import Base.LandingPage.Model.AllDifferentInputParamters;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface AllDifferentInputParametersInterface {
    @GetMapping(value = "/getMappingParamString")
    void getMappingParamString(@RequestBody String requestBodyParam);

    @GetMapping(value = "/getMappingParamJson")
    void getMappingParamJson(@RequestBody AllDifferentInputParamters requestBodyParam);

    @GetMapping(value = "/getMappingParamListJson")
    void getMappingParamListJson(@RequestBody List<AllDifferentInputParamters> requestBodyParam);

    @PostMapping(value = "/postMappingParamSingleValue")
    void postMappingParam(@RequestParam(name = "id") String val);

    @PostMapping(value = "/postMappingParamSingleValueWithMultipleValues")
    void postMappingParamWithMultipleValuesOfSameColumn(@RequestParam(name = "id") List<String> val);

    @PostMapping(value = "/postMappingParamSingleValueWithMultipleKeyValue")
    void postMappingParamWithMultipleKeyValue(@RequestParam Map<String, String> val);

    @GetMapping(value = "/getMappingException")
    ResponseEntity<String> getMappingThrowingException() throws MakeYourOwnException;
}
