package socialMediaApp.services;

import org.springframework.stereotype.Service;
import socialMediaApp.models.location.Country;
import socialMediaApp.repositories.location.CountryRepository;

import java.util.List;

@Service
public class LocationService {

    private CountryRepository countryRepository;

    public LocationService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
