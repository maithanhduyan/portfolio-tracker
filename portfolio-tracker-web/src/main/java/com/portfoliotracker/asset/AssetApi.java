package com.portfoliotracker.asset;

import java.util.List;
import java.util.Map;

import com.portfoliotracker.shared.datatable.DatatableRequest;
import com.portfoliotracker.shared.datatable.DatatableResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/asset")
public class AssetApi {

	private Logger log = LoggerFactory.getLogger(AssetApi.class);

	@Autowired
	AssetService assetService;

	@Autowired
	private DatatableRequest datatableRequest;

	@Autowired
	private DatatableResponse datatableResponse;

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
		// List<Asset> list = new ArrayList<Asset>();
		// list.add(new Asset("1", "BTC", 58000, null, null));
		return assetService.findList();
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Map<String, Object> getAll(@RequestParam Map<String, String> data) {
		try {

			datatableRequest.setDataRequest(data);
			log.info(data.toString());
			Page<Asset> _pageData = assetService.findAll(
					PageRequest.of(datatableRequest.getPage(), datatableRequest.getSize(),
							datatableRequest.getDirection(), datatableRequest.getColumn()),
					datatableRequest.getSearch());
			long recordsTotal = _pageData.getTotalElements();
			datatableResponse.setDraw(datatableRequest.getDraw());
			datatableResponse.setRecordsTotal(recordsTotal);
			datatableResponse.setRecordsFiltered(recordsTotal);
			datatableResponse.setContent(_pageData.getContent());
		} catch (Exception ex) {
			log.info("Error: " + ex.getMessage());
		}

		return datatableResponse.data();
	}
}
