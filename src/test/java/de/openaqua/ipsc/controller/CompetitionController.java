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
import de.openaqua.ipsc.entities.Competition;
import de.openaqua.ipsc.reps.CompetitionsRepository;

@Controller
@RequestMapping(path = "/competitions")
public class CompetitionController {
	private static final Log LOG = LogFactory.getLog(CompetitionController.class);
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10 };

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	SerialGenerator serialGenerator;

	@Autowired
	CompetitionsRepository compsRepository;

	@RequestMapping(method = RequestMethod.GET)
	@GetMapping("/")
	public ModelAndView index(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {

		ModelAndView modelAndView = new ModelAndView("competitions");

		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		// print repo

		Page<Competition> units = compsRepository.findAllByOrderByNameAsc(PageRequest.of(evalPage, evalPageSize));
		Pager pager = new Pager(units.getTotalPages(), units.getNumber(), BUTTONS_TO_SHOW);
		modelAndView.addObject("units", units);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;

	}

	@GetMapping("/byId/{id}")
	public String byId(@PathVariable final long id, final Model model) {
		LOG.debug("/byId/{id}");
		model.addAttribute("unit", compsRepository.findById(id));
		return "units";
	}

	@GetMapping("/byName/{name}")
	public String byId(@PathVariable final String unit, final Model model) {
		LOG.debug("/byUnit/{unit}");
		model.addAttribute("unit", compsRepository.findByName(unit));
		return "units";
	}

	// delete
	@GetMapping("/deleteCompetition/{id}")
	public String editUnit(@PathVariable final long id) {
		LOG.debug("/deleteUnit " + id);
		compsRepository.deleteById(id);
		return "redirect:/units";
	}

	// New
	@GetMapping("/newCompetition")
	public String newUnit(final Model model) {
		LOG.debug("GET /newUnit");
		model.addAttribute("unit", new Competition());
		return "units/newUnit";
	}

	@PostMapping(path = "/newCompetition")
	public String newUnit(@Valid CompetitionJSON unit, BindingResult bindingResult, final Model model) {
		LOG.debug("POST /newCompetition");
		Competition u = new Competition();
		u.setDescription(unit.getDescription());
		u.setName(unit.getName());
		u.setId(unit.getId());
		compsRepository.save(u);
		return "redirect:/units";
	}

	// Edit
	@GetMapping("/editCompetition/{id}")
	public String editUnit(@PathVariable final long id, final Model model) {
		LOG.debug("/editCompetition");
		Competition b = compsRepository.findById(id);
		model.addAttribute("competition", b);
		return "units/editUnit";
	}

	@PostMapping("/editCompetition/{id}")
	public String editUnit(@PathVariable final long id, @Valid CompetitionJSON b, BindingResult bindingResult,
			final Model model) {
		LOG.debug("/editCompetition");

		Competition u = compsRepository.findById(id);
		u.setDescription(b.getDescription());
		u.setName(b.getName());
		u.setId(b.getId());
		compsRepository.save(u);
		return "redirect:/competitions";
	}

}