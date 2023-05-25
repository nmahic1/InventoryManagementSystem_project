package service;

import repository.BrandAndCategoryRepository;

import java.sql.SQLException;

public class BrandAndCategoryService {
    private BrandAndCategoryRepository repository;

    public BrandAndCategoryService(BrandAndCategoryRepository repository) {
        this.repository = repository;
    }

    public void saveBrandAndCategory(String brand, String category) {
        try {
            repository.saveBrandAndCategory(brand, category);
        } catch (SQLException e) {
            // Obrada greške pri spremanju u bazu podataka
            e.printStackTrace();
            // Možete dodati logiku za prikazivanje poruke o grešci korisniku
        }
    }
}

