package com.UsedCar.controller;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.UsedCar.Model.CarModel;
import com.UsedCar.repository.Carrepository;

@Controller
public class CarController {
	
	@Autowired
	private Carrepository car;
	
	@GetMapping("/")
	public String welcome() {
		
		return "welcome";
		
	}
	@GetMapping("/searchbyBrand")
	public String byBrand(ModelMap m) {
		Set<String> brands=car.getbrands();
		brands.forEach(System.out::println);
		m.put("b", brands);
		return "byBrand";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("brand") String brand,ModelMap m) {
		List<CarModel> data=car.findByBrand(brand);
		m.put("data", data);
		System.out.println(brand);
		return "show";
	}
	@PostMapping("/booking")
	public String book(@RequestParam("id") int id,ModelMap m) {
		Optional<CarModel> d=car.findById(id);
		String brand=d.get().getBrand();
		String model=d.get().getModel();
		m.put("brand",brand);
		m.put("model",model);
		System.out.println(id);
		return "booked";
	}
	@GetMapping("/searchByprice")
	public String searchByprice() {
		return "byPrice";
	}

}
