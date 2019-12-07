package com.codingdojo.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.license.models.License;
import com.codingdojo.license.repositories.LicenseRepository;

@Service
public class LicenseService {

	private LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }
    // returns all the licenses
    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }
    
    // creates a license
    public License createLicense(License b) {
        return licenseRepository.save(b);
    }
    // retrieves a license
	    public License findLicense(Long id) {
	        Optional<License> optionalLicense = licenseRepository.findById(id);
	        if(optionalLicense.isPresent()) {
	            return optionalLicense.get();
	        } else {
	            return null;
	        }
	    }
		public void deleteLicense(Long id) {
			licenseRepository.deleteById(id);
			
		}
		public License updateLicense(License license) {	
			licenseRepository.save(license);
			return null;
		}
		public String generateLicenseNumber() {
			int licenseNumber = 0;
			if (licenseRepository.findTopByOrderByNumberDesc().isEmpty()) {
				licenseNumber = 1;
				return String.format("%05d", licenseNumber);
			}
			List<License> top = licenseRepository.findTopByOrderByNumberDesc();
			licenseNumber = 1 + (Integer.parseInt(top.get(0).getNumber()));
			return String.format("%05d", licenseNumber);
		}
}
