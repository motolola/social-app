package socialMediaApp.repositories.location;

import org.springframework.data.jpa.repository.JpaRepository;
import socialMediaApp.models.location.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
