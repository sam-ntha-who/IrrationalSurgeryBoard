package co.grandcircus.IrrationalSurgeryAddOns.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.grandcircus.IrrationalSurgeryAddOns.exceptions.SurgeryNotFoundException;
import co.grandcircus.IrrationalSurgeryAddOns.models.SurgicalCase;
import co.grandcircus.IrrationalSurgeryAddOns.repositories.SurgeryDepotRepository;

@RestController
public class SurgeryController {

	@Autowired
	SurgeryDepotRepository surgeryDepot;

	@ResponseBody
	@ExceptionHandler(SurgeryNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String SurgeryNotFoundHandler(SurgeryNotFoundException ex) {
		return ex.getMessage();
	}

//	@ResponseBody
//	@ExceptionHandler(SurgeonNotFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	String SurgeonNotFoundHandler(SurgeonNotFoundException ex) {
//		return ex.getMessage();
//	}

	// working
	@GetMapping("/reset")
	public String reset() {
		// delete first
		surgeryDepot.deleteAll();

		// create objects of type surgery
		SurgicalCase surgery = new SurgicalCase("Dr. Hamburglar", "Bobert, Bob", "6/8/76", true,
				"ingrown toenail right first toe", "RIGHT BELOW KNEE AMPUTATION", 90,
				new ArrayList<String>(Arrays.asList("latex allergy", "requests that thing he likes for positioning")),
				"after 1800", 1);
		surgeryDepot.insert(surgery);

		surgery = new SurgicalCase("Dr. Etrange", "Case, Justin", "10/5/99", false, "right distal humerus fracture",
				"LAPAROSCOPIC APPENDECTOMY POSSIBLE OPEN", 75,
				new ArrayList<String>(Arrays.asList("lithotomy", "to follow self", "PA")), "now", 2);
		surgeryDepot.insert(surgery);

		surgery = new SurgicalCase("Dr. BradPitt", "Shmenry, Henry", "2/13/45", true, "swallowed a clown toy",
				"CLOWNECTOMY", 100, new ArrayList<String>(Arrays.asList("PA", "supine")), "1400-2000", 3);
		surgeryDepot.insert(surgery);

		surgery = new SurgicalCase("Dr. BradPitt", "Ryan, Rusty", "3/20/75", true, "cholecystitis",
				"HARDWARE REMOVAL MANDIBLE", 80, new ArrayList<String>(Arrays.asList("dental tray", "ex fix removal")),
				"1400-2000", 4);
		surgeryDepot.insert(surgery);

		surgery = new SurgicalCase("Dr. Oz", "Phil, Doctor", "9/1/50", true, "ear ache",
				"INSERTION OF COCHLEAR IMPLANT", 120,
				new ArrayList<String>(Arrays.asList("I'm Dr. Oz I should be first", "page my assistant", "swivel chair",
						"Resident Assisting")),
				"after my show", 5);
		surgeryDepot.insert(surgery);
		return "Data reset.";
	}

// show all (cRud) working
	@GetMapping("/surgery")
	public List<SurgicalCase> showAllSurgeries() {
		return surgeryDepot.findAll();
	}

// show one	(cRud) working
	@GetMapping("/surgery/{id}")
	public SurgicalCase showOneCase(@PathVariable String id) {
		return surgeryDepot.findById(id).orElseThrow(() -> new SurgeryNotFoundException(id));

	}
	// show all for surgeon (cRud) needs work

	// @GetMapping("/surgery/{surgeon}")
	// public Optional<SurgicalCase> showAllForSurgeon(@PathVariable String surgeon)
	// {
	// return surgeryDepot.findBySurgeon(surgeon);
	//
	// }

	// update one by id (crUd) working
	@PutMapping("/surgery/{id}")
	public SurgicalCase updateOne(@PathVariable String id, @RequestBody SurgicalCase surgery) {

		return surgeryDepot.save(surgery);
	}

	// works for updating single field
	// needs access for updating multiple fields at once (probably
	@PatchMapping("/surgery/{id}")
	public SurgicalCase updateField(@PathVariable String id, @RequestParam(required = false) String surgeon,
			@RequestParam(required = false) String name, @RequestParam(required = false) String dateOfBirth,
			@RequestParam(required = false) Boolean isInpatient, @RequestParam(required = false) String diagnosis,
			@RequestParam(required = false) String procedure, @RequestParam(required = false) Integer minutes,
			@RequestParam(required = false) List<String> comments,
			@RequestParam(required = false) String drAvailability,
			@RequestParam(required = false) Integer toFollowBoardNum) {

		SurgicalCase surgery = surgeryDepot.findById(id).get();

		if (surgeon != null) {
			surgery.setSurgeon(surgeon);
		} else if (name != null) {
			surgery.setName(name);
		} else if (dateOfBirth != null) {
			surgery.setDateOfBirth(dateOfBirth);
		} else if (isInpatient != null) {
			surgery.setIsInpatient(isInpatient);
		} else if (diagnosis != null) {
			surgery.setDiagnosis(diagnosis);
		} else if (procedure != null) {
			surgery.setProcedure(procedure);
		} else if (minutes != null) {
			surgery.setMinutes(minutes);
		} else if (comments != null) {
			surgery.setComments(comments);
		} else if (drAvailability != null) {
			surgery.setDrAvailability(drAvailability);
		} else if (toFollowBoardNum != null) {
			surgery.setToFollowBoardOrder(toFollowBoardNum);
		}

		return surgeryDepot.save(surgery);
	}
	// create one (Crud) working
	// need to be able to increment or decrement the surgery add on number as it
	// changes

	@PostMapping("/surgery")
	@ResponseStatus(HttpStatus.CREATED)
	public SurgicalCase create(@RequestBody SurgicalCase surgery) {

		Integer tfbNum = (int) surgeryDepot.count() + 1;
		surgery.setToFollowBoardOrder(tfbNum);

		return surgeryDepot.insert(surgery);
	}

// delete one (cruD) working
	@DeleteMapping("/surgery/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeCase(@PathVariable String id) {
		surgeryDepot.deleteById(id);

	}

// 
}
