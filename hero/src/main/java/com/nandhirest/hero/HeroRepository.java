package com.voizfonica.webapp.data;

import com.voizfonica.webapp.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(collectionResourceRel = "Favourite Hero List", path = "hero")
public interface HeroRepository extends JpaRepository<Hero,Long> {

}
