package Base.LandingPage.Controller;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.*;

@RestController
public class AllDifferentRequestTypes implements AllDifferentRequestTypesInterface {

    @Override
    @GetMapping(value = "/getMapping")
    public String getMapping() {
        return "GetMapping request done successfully";
    }

    @Override
    @PutMapping(value = "/putMapping")
    public String putMapping() {
        return "PutMapping request done successfully";
    }

    @Override
    @PostMapping(value = "/postMapping")
    public String postMapping() {
        return "PostMapping request done successfully";
    }

    @Override
    @DeleteMapping(value = "/deleteMapping")
    public String deleteMapping() {
        return "DeleteMapping request done successfully";
    }

    @Override
    @PatchMapping(value = "/patchMapping")
    public String patchMapping() {
        return "PatchMapping request done successfully";
    }
}
