package au.com.ps.opal.dao.impl;

import au.com.ps.opal.domain.OpalCard;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<OpalCard, String>{
}
