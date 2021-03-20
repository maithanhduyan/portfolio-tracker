package com.portfoliotracker.asset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssetController {

	@RequestMapping("/asset")
	public String assestPage() {
		return "asset/asset";
	}
}
