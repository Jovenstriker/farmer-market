package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Produce;

public interface ProduceRepository extends JpaRepository<Produce, Long> {

}
