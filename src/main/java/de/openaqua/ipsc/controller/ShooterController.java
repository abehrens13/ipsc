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

import de.openaqua.ipsc.entities.Country;
import de.openaqua.ipsc.entities.Shooter;
import de.openaqua.ipsc.entities.ShooterJSON;
import de.openaqua.ipsc.reps.CountryRepository;
import de.openaqua.ipsc.reps.ShooterRepository;

@Controller
@RequestMapping(path = "/shooters")
public class ShooterController {
	private static final Log LOG = LogFactory.getLog(ShooterController.class);
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 10;
	private static final int[] PAGE_SIZES = { 5, 10 };

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	ShooterRepository compsRepository;
	
	@Autowired
	CountryRepository countryRepository;

	@Autowired
	ContryController countryController;

	@RequestMapping(method = RequestMethod.GET)
	@GetMapping("/")
	public ModelAndView index(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		
		Page<Shooter> comps = compsRepository.findAllByOrderByLastnameAsc(PageRequest.of(evalPage, evalPageSize));
		Pager pager = new Pager(comps.getTotalPages(), comps.getNumber(), BUTTONS_TO_SHOW);

		ModelAndView modelAndView = new ModelAndView("shooters");
		modelAndView.addObject("shooters", comps);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;

	}

	@GetMapping("/byId/{id}")
	public String byId(@PathVariable final long id, final Model model) {
		LOG.debug("/byId/{id}");
		model.addAttribute("shooter", compsRepository.findById(id));
		return "shooter";
	}

	// delete
	@GetMapping("/deleteShooter/{id}")
	public String editShooter(@PathVariable final long id) {
		LOG.debug("/deleteShooter " + id);
		compsRepository.deleteById(id);
		return "redirect:/shooters";
	}

	// New
	@GetMapping("/newShooter")
	public String newShooter(final Model model) {
		LOG.debug("GET /newShooter");
		model.addAttribute("shooter", new Shooter());
		model.addAttribute("countries", countryRepository.findAllByOrderByCodeAsc());
		return "shooters/newShooter";
	}

	public void convertShooterJSON2Shooter(final ShooterJSON in, final Shooter out) {

		Country outCountry = new Country();
		countryController.convertCountryJSON2Country(in.getCountry(), outCountry);

		out.setCountry(outCountry);
		out.setEmail(in.getEmail());
		out.setFirstname(in.getFirstname());
		out.setId(in.getId());
		out.setIpsc_licence(in.getIpsc_licence());
		out.setLastname(in.getLastname());
		out.setPassword(in.getPassword());
		out.setUsername(in.getUsername());

	}

	@PostMapping(path = "/newShooter")
	public String newShooter(@Valid ShooterJSON in, BindingResult bindingResult, final Model model) {
		LOG.debug("POST /newShooter");
		Shooter out = new Shooter();
		convertShooterJSON2Shooter(in, out);
		compsRepository.save(out);
		return "redirect:/shooters";
	}

	// Edit
	@GetMapping("/editShooter/{id}")
	public String editShooter(@PathVariable final long id, final Model model) {
		LOG.debug("/editShooter");
		Shooter b = compsRepository.findById(id);
		model.addAttribute("shooter", b);
		model.addAttribute("countries", countryRepository.findAllByOrderByCodeAsc());
		return "shooters/editShooter";
	}

	@PostMapping("/editShooter/{id}")
	public String editShooter(@PathVariable final long id, @Valid ShooterJSON in, BindingResult bindingResult,
			final Model model) {
		LOG.debug("/editShooter");

		Shooter out = compsRepository.findById(id);
		convertShooterJSON2Shooter(in, out);

		compsRepository.save(out);
		return "redirect:/shooters";
	}

}