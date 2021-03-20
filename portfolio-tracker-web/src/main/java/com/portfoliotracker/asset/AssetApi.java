package com.portfoliotracker.asset;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/asset")
public class AssetApi {
	
	@Autowired
	AssetService assetService;
	
	public AssetApi() {

	}

	@RequestMapping(value = "/heathcheck", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public String assetHeathCheck() {
		return "I am OK";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<Asset> assetList() {
		//List<Asset> list = new ArrayList<Asset>();
		//list.add(new Asset("1", "BTC", 58000, null, null));
		return assetService.findList();
	}
}
