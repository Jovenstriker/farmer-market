package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Event;

@Repository
public interface BusinessEventRepository extends JpaRepository <Event, Long>{

}
