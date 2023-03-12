package com.TechInc.blog.repositories;
import com.TechInc.blog.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EquipmentRepository extends JpaRepository<Equipment, Long> { }