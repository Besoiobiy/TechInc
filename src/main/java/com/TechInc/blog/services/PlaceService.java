package com.TechInc.blog.services;
import com.TechInc.blog.models.Equipment;
import com.TechInc.blog.models.Place;
import com.TechInc.blog.models.User;
import com.TechInc.blog.repositories.EquipmentRepository;
import com.TechInc.blog.repositories.PlaceRepository;
import com.TechInc.blog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.HashMap;
@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;
    public void savePlace(Principal principal, HashMap formData) {
        Place place = new Place();
        place.setUser(getUserByPrincipal(principal));
        var valuesForm = formData.values().iterator();
        place.setTitle(valuesForm.next().toString());
        place.setOrganization(valuesForm.next().toString());
        while (valuesForm.hasNext()) {
            String next = valuesForm.next().toString();
            if (next.isEmpty())
                break;
            Equipment equipment = new Equipment();
            equipment.setCharacteristic(next);
            equipment.setId(valuesForm.next().toString());
            place.addEquipmentToPlace(equipment);
        }
        placeRepository.save(place);
        log.info("Saving new Place.");
    }
    public void deletePlace(Long id){
        placeRepository.deleteById(id);
    }
    public void invertPlace(Long id){
        Place invert = getPlaceById(id);
        if (invert.isChecked()){
            invert.setChecked(false);
        }
        else {
            invert.setChecked(true);
        }
        placeRepository.save(invert);
    }
    public void invertAccept(Long id, HashMap formData){
        var place = getPlaceById(id);
        int i=1;
        for (var itVar : place.getEquipments())
        {
            itVar.setAccounting(formData.containsKey("accounting_"+i));
            itVar.setFact(formData.containsKey("fact_"+i));
            itVar.setStatus(formData.get("status_"+i).toString());
            i++;
        }
        placeRepository.save(place);
    }
    public List<Place> listPlace(User user) {
        if (user.isDirector()){
            return placeRepository.findByUser(user);
        } else if (user.isWorker()){
            return placeRepository.findByChecked(false);
        }
        return placeRepository.findAll();
    }
    public Place getPlaceById(Long id){
        return placeRepository.getById(id);
    }
    public User getUserByPrincipal(Principal principal) {
        return userRepository.findByEmail(principal.getName());
    }
}