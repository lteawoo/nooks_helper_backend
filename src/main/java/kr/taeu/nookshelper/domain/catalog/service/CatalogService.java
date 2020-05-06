package kr.taeu.nookshelper.domain.catalog.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.stereotype.Service;

import kr.taeu.nookshelper.domain.catalog.util.OAuth2Util;

@Service
public class CatalogService {
	private final String SHEET_ID = "1mo7myqHry5r_TKvakvIhHbcEAEQpSiNoNQoIS8sMpvM";
	private final String[] ITEM_SHEETS = {
			"Housewares",
			"Miscellaneous",
			"Wall-mounted",
			"Wallpapers",
			"Floors",
			"Rugs",
			"Fencing",
			"Photos",
			"Posters",
			"Tools",
			"Tops",
			"Bottoms",
			"Dress-Up",
			"Headwear",
			"Accessories",
			"Socks",
			"Shoes",
			"Bags",
			"Umbrellas",
			"Music",
			"Fossils",
			"Other",
			"Art",
	};
	private final String[] CREATURE_SHEETS = {
			"Fish",
			"Bugs",
	};
	private final String[] NOOK_MILE_SHEETS = {
			"Nook Miles"
	};

	private final String[] RECIPE_SHEETS = {
			"Recipes"
	};

	private final String[] VILLAGERS_SHEETS = {
			"Villagers"
	};

	private final String[] CONSTRUCTION_SHEETS = {
			"Construction"
	};

	private final String[] ACHIEVEMENTS_SHEETS = {
			"Achievements"
	};

	private final String[] REACTIONS_SHEETS = {
			"Reactions"
	};
	
	public void getCredentials(){
		try {
			OAuth2Util.test();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}
}
