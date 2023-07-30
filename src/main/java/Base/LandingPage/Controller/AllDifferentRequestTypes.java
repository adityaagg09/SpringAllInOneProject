package Base.LandingPage.Controller;

import Base.LandingPage.API.CallingCode;
import Base.LandingPage.Model.SendingAndReceivingDifferentNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class AllDifferentRequestTypes {

    @Autowired
    private CallingCode callingCode;


    @GetMapping(value = "/getMapping")
    public ResponseEntity<SendingAndReceivingDifferentNames> getMapping() {
        SendingAndReceivingDifferentNames resObj = new SendingAndReceivingDifferentNames();
        resObj.setNameOfParameterInThisOrderWhichYouAreRecevingFromAnyOtherService("Hello");
        return new ResponseEntity<>(resObj, HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping(value = "/putMapping")
    public String putMapping() {
        return "PutMapping request done successfully";
    }


    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_VIEW_ONLY')")
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

    @GetMapping(value = "/hitttingTheApi")
    public String getApiValue() {
        return  callingCode.getDataFromApi();
    }


}
