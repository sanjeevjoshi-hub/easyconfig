package com.example.easyconfig.repository;

import com.example.easyconfig.model.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config, Integer> {
}