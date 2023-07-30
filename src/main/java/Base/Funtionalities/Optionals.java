package Base.Funtionalities;

import Base.LandingPage.Model.AllDifferentInputParamters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class Optionals {

    private static final Logger LOGGER = LoggerFactory.getLogger(Optionals.class);

    public void handsOn() {

        AllDifferentInputParamters allDifferentInputParamters = new AllDifferentInputParamters();
        allDifferentInputParamters.setLastName(null);

        // It will create an empty optional
        Optional<Object> emptyOptional = Optional.empty();

        // It will check if obj is null then throw a null pointer exception
        Optional<String> ofOptional = Optional.of(allDifferentInputParamters.getLastName());

        // If obj is null then will assign empty optional else it will go with ofOptional functionality
        Optional<String> ofNullableOptional = Optional.ofNullable(allDifferentInputParamters.getLastName());

        // It will throw error if value is not preset
        String valueFromOptional = ofNullableOptional.get(); // By this we get the value which we set in our optional

        // To avoid the exception, it will check if value is present or not ?
        if( ofNullableOptional.isPresent() ) {
            valueFromOptional = ofNullableOptional.get();
        }

        // Retuning the optional value
        valueFromOptional = ofNullableOptional.orElse("Testing"); // If value doesn't exist will return this

        // IF value is null throw exception according to your needs
        ofNullableOptional.orElseThrow(() -> new NullPointerException("Faad dia code"));

        ofNullableOptional.map(String::toUpperCase).orElseGet(() -> "Testingggg");
        

    }

}
