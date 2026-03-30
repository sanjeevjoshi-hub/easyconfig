package com.example.easyconfig.service;

import com.example.easyconfig.model.Config;
import com.example.easyconfig.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {

    @Autowired
    private ConfigRepository repo;

    // Save data
    public Config saveConfig(Config config) {
        return repo.save(config);
    }

    // Get all data
    public List<Config> getAllConfigs() {
        return repo.findAll();
    }
    // Get config by ID
    public Config getConfigById(int id) {
        return repo.findById(id).orElse(null);
    }
    // Update config
    public Config updateConfig(int id, Config config) {
        Config existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(config.getName());
            existing.setValue(config.getValue());
            existing.setEnvironment(config.getEnvironment());
            return repo.save(existing);
        }
        return null;
    }

    // Delete config
    public void deleteConfig(int id) {
        repo.deleteById(id);
    }
}
