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
import de.openaqua.ipsc.entities.CompetitionType;
import de.openaqua.ipsc.entities.CompetitionTypeJSON;
import de.openaqua.ipsc.reps.CompetitionTypeRepository;

@Controller
@RequestMapping(path = "/competitionTypes")
public class CompetitionTypeController {
	private static final Log LOG = LogFactory.getLog(CompetitionTypeController.class);
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10 };

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	SerialGenerator serialGenerator;

	@Autowired
	CompetitionTypeRepository compsRepository;

	@RequestMapping(method = RequestMethod.GET)
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("competitionTypes");
		Iterable<CompetitionType> comps = compsRepository.findAllByOrderByNameAsc();
		modelAndView.addObject("competitionTypes", comps);
		return modelAndView;

	}

	@GetMapping("/byId/{id}")
	public String byId(@PathVariable final long id, final Model model) {
		LOG.debug("/byId/{id}");
		model.addAttribute("competitionType", compsRepository.findById(id));
		return "competitionType";
	}

	@GetMapping("/byName/{name}")
	public String byId(@PathVariable final String unit, final Model model) {
		LOG.debug("/byName/{name}");
		model.addAttribute("competitionType", compsRepository.findByName(unit));
		return "competitionType";
	}

	// delete
	@GetMapping("/deleteCompetitionType/{id}")
	public String editCompetitionType(@PathVariable final long id) {
		LOG.debug("/deleteCompetitionType " + id);
		compsRepository.deleteById(id);
		return "redirect:/competitionTypes";
	}

	// New
	@GetMapping("/newCompetitionType")
	public String newCompetitionType(final Model model) {
		LOG.debug("GET /newCompetitionType");
		model.addAttribute("competitionType", new CompetitionType());
		return "competitionTypes/newCompetitionType";
	}

	@PostMapping(path = "/newCompetitionType")
	public String newCompetitionType(@Valid CompetitionTypeJSON unit, BindingResult bindingResult, final Model model) {
		LOG.debug("POST /newCompetitionType");
		CompetitionType u = new CompetitionType();
		u.setDescription(unit.getDescription());
		u.setName(unit.getName());
		u.setId(unit.getId());
		compsRepository.save(u);
		return "redirect:/competitionTypes";
	}

	// Edit
	@GetMapping("/editCompetitionType/{id}")
	public String editCompetitionType(@PathVariable final long id, final Model model) {
		LOG.debug("/editCompetitionType");
		CompetitionType b = compsRepository.findById(id);
		model.addAttribute("competitionType", b);
		return "competitionTypes/editCompetitionType";
	}

	@PostMapping("/editCompetitionType/{id}")
	public String editCompetitionType(@PathVariable final long id, @Valid CompetitionTypeJSON b, BindingResult bindingResult,
			final Model model) {
		LOG.debug("/editCompetitionType");

		CompetitionType u = compsRepository.findById(id);
		u.setDescription(b.getDescription());
		u.setName(b.getName());
		u.setId(b.getId());
		compsRepository.save(u);
		return "redirect:/competitionTypes";
	}

}