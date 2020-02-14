package de.openaqua.ipsc.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.openaqua.ipsc.beans.SerialGenerator;
import de.openaqua.ipsc.entities.Country;
import de.openaqua.ipsc.entities.CountryJSON;
import de.openaqua.ipsc.reps.CountryRepository;

@Controller
@RequestMapping(path = "/countries")
public class ContryController {
	private static final Log LOG = LogFactory.getLog(ContryController.class);
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 10;
	private static final int[] PAGE_SIZES = { 5, 10 };

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	SerialGenerator serialGenerator;

	@Autowired
	CountryRepository compsRepository;

	@RequestMapping(method = RequestMethod.GET)
	@GetMapping("/")
	public ModelAndView index(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {

		ModelAndView modelAndView = new ModelAndView("countries");

		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		// print repo

		Page<Country> comps = compsRepository.findAllByOrderByCodeAsc(PageRequest.of(evalPage, evalPageSize));
		Pager pager = new Pager(comps.getTotalPages(), comps.getNumber(), BUTTONS_TO_SHOW);
		modelAndView.addObject("countries", comps);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;

	}

	@GetMapping("/byId/{id}")
	public String byId(@PathVariable final long id, final Model model) {
		LOG.debug("/byId/{id}");
		model.addAttribute("country", compsRepository.findById(id));
		return "country";
	}

	@GetMapping("/byCode/{code}")
	public String byId(@PathVariable final String unit, final Model model) {
		LOG.debug("/byCode/{code}");
		model.addAttribute("country", compsRepository.findByCode(unit));
		return "country";
	}

	// delete
	@GetMapping("/deleteCountry/{id}")
	public String editCountry(@PathVariable final long id) {
		LOG.debug("/deleteCountry " + id);
		compsRepository.deleteById(id);
		return "redirect:/countries";
	}

	// New
	@GetMapping("/newCountry")
	public String newCountry(final Model model) {
		LOG.debug("GET /newCountry");
		model.addAttribute("country", new Country());
		return "countries/newCountry";
	}

	@PostMapping(path = "/newCountry")
	public String newCountry(@Valid CountryJSON unit, BindingResult bindingResult, final Model model) {
		LOG.debug("POST /newCountry");
		Country u = new Country();
		convertCountryJSON2Country(unit, u);
		compsRepository.save(u);
		return "redirect:/countries";
	}

	// Edit
	@GetMapping("/editCountry/{id}")
	public String editCountry(@PathVariable final long id, final Model model) {
		LOG.debug("/editCountry");
		Country b = compsRepository.findById(id);
		model.addAttribute("country", b);
		return "countries/editCountry";
	}

	@PostMapping("/editCountry/{id}")
	public String editCountry(@PathVariable final long id, @Valid CountryJSON unit, BindingResult bindingResult,
			final Model model) {
		LOG.debug("/editCountry");

		Country u = compsRepository.findById(id);
		convertCountryJSON2Country(unit, u);

		compsRepository.save(u);
		return "redirect:/countries";
	}

	public void convertCountryJSON2Country(final CountryJSON in, Country out) {
		if (in == null) {
			out = null;
			return;
		}
		out.setCode(in.getCode());
		out.setId(in.getId());
		out.setName_de(in.getName_de());
		out.setName_en(in.getName_en());
		out.setName_fr(in.getName_fr());
	}

}