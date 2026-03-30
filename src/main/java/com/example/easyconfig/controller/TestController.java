package com.example.easyconfig.controller;

import com.example.easyconfig.model.Config;
import com.example.easyconfig.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configs")
public class TestController {

    @Autowired
    private ConfigService service;

    // CREATE
    @PostMapping
    public Config addConfig(@RequestBody Config config) {
        return service.saveConfig(config);
    }

    // READ (GET ALL)
    @GetMapping
    public List<Config> getAllConfigs() {
        return service.getAllConfigs();
    }

    // READ (GET BY ID)
    @GetMapping("/{id}")
    public Config getConfigById(@PathVariable int id) {
        return service.getConfigById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Config updateConfig(@PathVariable int id, @RequestBody Config config) {
        return service.updateConfig(id, config);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteConfig(@PathVariable int id) {
        service.deleteConfig(id);
        return "Deleted successfully";
    }
}