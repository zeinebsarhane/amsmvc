package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.Candidat;

@Controller
@RequestMapping("/first")
public class FirstController {

	ArrayList<Candidat> cs = new ArrayList<>();
	{
	cs.add(new Candidat("seif", "zakhma", "s@gmail.com"));
	cs.add(new Candidat("amine", "souissia", "a@gmail.com"));
	cs.add(new Candidat("medAli", "hajri", "m@gmail.com"));
	}
	
	@RequestMapping("/home")
//	@ResponseBody
	public String home(Model modele) {
		String name="amine";
		String email="amine.mezghich@gmail.com";
		
		modele.addAttribute("nom", name);
		modele.addAttribute("mail", email);

		return "First/home";
//		return name;
	}
	
	@RequestMapping("/names")
	public String getNames(Model m) {
		
		ArrayList<String> noms = new ArrayList<>();
		
		noms.add("Med Ali");
		noms.add("Alya");
		noms.add("Takwa");
		
		int total=noms.size();
		m.addAttribute("noms", noms);
		m.addAttribute("total", total);
		
		return "First/names";
	}
	
	
	
	@RequestMapping("/candidats")
	public String getCandidats(Model m) {
		
//		ArrayList<Candidat> cs = new ArrayList<>();
//	
//		cs.add(new Candidat("seif", "zakhma", "s@gmail.com"));
//		cs.add(new Candidat("amine", "souissia", "a@gmail.com"));
//		cs.add(new Candidat("medAli", "hajri", "m@gmail.com"));
		
		int total=cs.size();
//		cs = null;
		m.addAttribute("cs", cs);
		m.addAttribute("total", total);
		
		return "First/candidates";
	}
	

	@GetMapping("/add")
	public String addCandidate() {
		
		return "First/addCandidat";
	}
	
	
	
	@PostMapping("/add")
//	@ResponseBody
	public String saveCandidate(@RequestParam (name="nom") String nom,
			@RequestParam (name="prenom") String prenom,
			@RequestParam (name="email") String email) {
		
		Candidat temp = new Candidat(nom, prenom, email);
		cs.add(temp);
	
		return "redirect:candidats";
	}
	
	
}
