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
import de.openaqua.ipsc.entities.DevisionType;
import de.openaqua.ipsc.entities.DevisionTypeJSON;
import de.openaqua.ipsc.reps.DevisionTypeRepository;

@Controller
@RequestMapping(path = "/devisionTypes")
public class DevisionTypeController {
	private static final Log LOG = LogFactory.getLog(DevisionTypeController.class);
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10 };

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	SerialGenerator serialGenerator;

	@Autowired
	DevisionTypeRepository compsRepository;

	@RequestMapping(method = RequestMethod.GET)
	@GetMapping("/")
	public ModelAndView index(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {

		ModelAndView modelAndView = new ModelAndView("devisionTypes");

		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		// print repo

		Page<DevisionType> comps = compsRepository.findAllByOrderByNameAsc(PageRequest.of(evalPage, evalPageSize));
		Pager pager = new Pager(comps.getTotalPages(), comps.getNumber(), BUTTONS_TO_SHOW);
		modelAndView.addObject("devisionTypes", comps);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;

	}

	@GetMapping("/byId/{id}")
	public String byId(@PathVariable final long id, final Model model) {
		LOG.debug("/byId/{id}");
		model.addAttribute("devisionType", compsRepository.findById(id));
		return "devisionType";
	}

	@GetMapping("/byName/{name}")
	public String byId(@PathVariable final String unit, final Model model) {
		LOG.debug("/byName/{name}");
		model.addAttribute("devisionType", compsRepository.findByName(unit));
		return "devisionType";
	}

	// delete
	@GetMapping("/deleteDevisionType/{id}")
	public String editDevisionType(@PathVariable final long id) {
		LOG.debug("/deleteDevisionType " + id);
		compsRepository.deleteById(id);
		return "redirect:/devisionTypes";
	}

	// New
	@GetMapping("/newDevisionType")
	public String newDevisionType(final Model model) {
		LOG.debug("GET /newDevisionType");
		model.addAttribute("devisionType", new DevisionType());
		return "devisionTypes/newDevisionType";
	}

	@PostMapping(path = "/newDevisionType")
	public String newDevisionType(@Valid DevisionTypeJSON unit, BindingResult bindingResult, final Model model) {
		LOG.debug("POST /newDevisionType");
		DevisionType u = new DevisionType();
		u.setDescription(unit.getDescription());
		u.setName(unit.getName());
		u.setId(unit.getId());
		compsRepository.save(u);
		return "redirect:/devisionTypes";
	}

	// Edit
	@GetMapping("/editDevisionType/{id}")
	public String editDevisionType(@PathVariable final long id, final Model model) {
		LOG.debug("/editDevisionType");
		DevisionType b = compsRepository.findById(id);
		model.addAttribute("devisionType", b);
		return "devisionTypes/editDevisionType";
	}

	@PostMapping("/editDevisionType/{id}")
	public String editDevisionType(@PathVariable final long id, @Valid DevisionTypeJSON b, BindingResult bindingResult,
			final Model model) {
		LOG.debug("/editDevisionType");

		DevisionType u = compsRepository.findById(id);
		u.setDescription(b.getDescription());
		u.setName(b.getName());
		u.setId(b.getId());
		compsRepository.save(u);
		return "redirect:/devisionTypes";
	}

}