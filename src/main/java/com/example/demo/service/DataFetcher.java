package com.example.demo.service;

import com.example.demo.entity.Abilitiy;
import com.example.demo.entity.Stats;
import com.example.demo.entity.Weapon;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataFetcher {
    @Autowired
    RestTemplate restTemplate;

    public Stats fetchStats() {
        String url = "https://example.com/stats";
        Stats stats = restTemplate.getForObject(url, Stats.class);
        return stats;
    }

    public List<Weapon> fetchWeapon() {
        String url = "https://example.com/weapon";
        ResponseEntity<Weapon[]> response = restTemplate.getForEntity(url, Weapon[].class);
        Weapon[] weaponsArray = response.getBody();
        List<Weapon> weapons = Arrays.asList(weaponsArray);
        return weapons;
    }

    public List<Abilitiy> fetchAbilities() {
        String url = "https://example.com/abilities";
        ResponseEntity<List<Abilitiy>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParametrizedTypeReference<List<Abilitiy>>() {}
        );
    }
}
