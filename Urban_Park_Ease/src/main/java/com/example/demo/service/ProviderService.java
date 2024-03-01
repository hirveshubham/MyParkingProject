package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.ProviderModel;
@Service
public interface ProviderService {
	
	void saveProvider(ProviderModel s);

	List<ProviderModel> getAllProviders();

	void deleteProviderById(Long id);

	ProviderModel getProviderById(Long id);
	
	
	Optional<ProviderModel> getProviderForEdit(Long id);

}


