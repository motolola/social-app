package socialMediaApp.repositories.location;

import org.springframework.data.jpa.repository.JpaRepository;
import socialMediaApp.models.location.State;

public interface StateRepository extends JpaRepository<State, Long> {
}
