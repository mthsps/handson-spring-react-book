package com.org.cardatabase.repository;

import com.org.cardatabase.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
