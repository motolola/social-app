package socialMediaApp.repositories.location;

import org.springframework.data.jpa.repository.JpaRepository;
import socialMediaApp.models.location.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
