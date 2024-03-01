package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProviderModel;
import com.example.demo.repository.ProviderRepository;
@Service
public class ProviderServiceImplementation implements  ProviderService 
{
	
	@Autowired
	ProviderRepository addr;

	@Override
	public void saveProvider(ProviderModel s)
	{
		addr.save(s);
		
	}
	
	 @Override
	    public List<ProviderModel> getAllProviders() {
	         return addr.findAll();
	    }

	@Override
	public void deleteProviderById(Long id) {
		addr.deleteById(id);
		
	}

	@Override
	public ProviderModel getProviderById(Long id) {
		Optional<ProviderModel> providerOptional = addr.findById(id);
        return providerOptional.orElse(null);
        }

	@Override
	public Optional<ProviderModel> getProviderForEdit(Long id) {
		// TODO Auto-generated method stub
		return addr.findById(id);
	}
}
