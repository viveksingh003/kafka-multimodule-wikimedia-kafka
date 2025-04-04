package com.codelounge.springboot.kafka.repository;

import com.codelounge.springboot.kafka.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepo extends JpaRepository <WikimediaData,Long>{


}
