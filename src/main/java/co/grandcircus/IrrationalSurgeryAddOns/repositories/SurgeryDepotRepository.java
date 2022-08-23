package co.grandcircus.IrrationalSurgeryAddOns.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.grandcircus.IrrationalSurgeryAddOns.models.SurgicalCase;

public interface SurgeryDepotRepository extends MongoRepository<SurgicalCase, String>{

	List<SurgicalCase> findAll();
	Optional<SurgicalCase> findById(String id);
	Optional<SurgicalCase> findBySurgeon(String surgeon);
	
}
