package com.consumer.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consumer.springboot.entity.WikimediaData;

public interface WikimediaRepository extends JpaRepository<WikimediaData,Long> {

}
