package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BookingModel;
@Repository
public interface BookingRepository extends JpaRepository<BookingModel,Long>  {

	List<BookingModel> findByEmail(String userEmail);

}
