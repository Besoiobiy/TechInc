package com.TechInc.blog.repositories;
import com.TechInc.blog.models.Place;
import com.TechInc.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findByUser(User user);
    List<Place> findByChecked(boolean checked);
}