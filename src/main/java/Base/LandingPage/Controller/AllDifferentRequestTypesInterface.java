package Base.LandingPage.Controller;

import org.springframework.web.bind.annotation.*;

public interface AllDifferentRequestTypesInterface {
    @GetMapping(value = "/getMapping")
    String getMapping();

    @PutMapping(value = "/putMapping")
    String putMapping();

    @PostMapping(value = "/postMapping")
    String postMapping();

    @DeleteMapping(value = "/deleteMapping")
    String deleteMapping();

    @PatchMapping(value = "/patchMapping")
    String patchMapping();
}
