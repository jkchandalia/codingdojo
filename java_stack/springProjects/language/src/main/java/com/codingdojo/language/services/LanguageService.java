package com.codingdojo.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.language.models.Language;
import com.codingdojo.language.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
		
	}
	public Language updateLanguage(Language language) {	
		languageRepository.save(language);
		return null;
	}
}
