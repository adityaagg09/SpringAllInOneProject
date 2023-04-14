package Base.LandingPage.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AllDifferentRequestTypes {


    @GetMapping(value = "/getMapping")
    public String getMapping() {
        return "GetMapping request done successfully";
    }


    @PutMapping(value = "/putMapping")
    public String putMapping() {
        return "PutMapping request done successfully";
    }


    @PostMapping(value = "/postMapping")
    public String postMapping() {
        return "PostMapping request done successfully";
    }


    @DeleteMapping(value = "/deleteMapping")
    public String deleteMapping() {
        return "DeleteMapping request done successfully";
    }


    @PatchMapping(value = "/patchMapping")
    public String patchMapping() {
        return "PatchMapping request done successfully";
    }


}
