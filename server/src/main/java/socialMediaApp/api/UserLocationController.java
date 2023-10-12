package socialMediaApp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import socialMediaApp.models.location.Country;
import socialMediaApp.services.LocationService;

import java.util.List;

@RestController
@RequestMapping("api/location")
public class UserLocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping(name = "/getAllCountries")
    public ResponseEntity<List<Country>> getAllCountries() {

        return new ResponseEntity<>(locationService.getAllCountries(), HttpStatus.OK);
    }
}
