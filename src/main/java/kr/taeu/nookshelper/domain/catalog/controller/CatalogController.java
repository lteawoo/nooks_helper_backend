package kr.taeu.nookshelper.domain.catalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.taeu.nookshelper.domain.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/catalog")
@RequiredArgsConstructor
public class CatalogController {
	private final CatalogService catalogService;
	
	@GetMapping(value = "/test")
	public String test() {
		catalogService.getCredentials();
		
		return "hello World";
	}
}
