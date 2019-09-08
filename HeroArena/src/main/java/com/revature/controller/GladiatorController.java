package com.revature.controller;

import java.util.Set;

import com.revature.services.GladiatorService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Gladiator;
import com.revature.beans.User;

import javax.servlet.http.HttpSession;


@Controller
@CrossOrigin
public class GladiatorController {

	@Autowired
	private GladiatorService gs;
	@Autowired
	private UserService userServ;

	@Autowired
	private UserService us;
	/*// this actually gets the gladiator by gladiator id
	@RequestMapping(value="/gladiator")
	@GetMapping("{play}")
	@ResponseBody
	public Set<Gladiator> getGladiatorsByUser(@PathVariable("play") Integer id) {
		User u = ud.getUser(id);
		return gd.getGladiatorsForUser(u);
	}*/
	
	@ResponseBody
	@PostMapping(value="/gladiator")
	public Set<Gladiator> getGladiatorsByUser(String id) {
		User u = us.getUser(Integer.parseInt(id));
		return gs.getGladiatorsByUser(u.getId());
	}

	@GetMapping("all")
	@ResponseBody
	public Set<Gladiator> getAllGladiators() {
		return gs.getAllGladiators();
	}

	@GetMapping("/gladiator/opponents")
    @ResponseBody
    public ResponseEntity<Set<Gladiator>> getAllOpponents(@RequestParam Integer userId, HttpSession session)
    {
    	//User user = (User) session.getAttribute("user");
		User user = userServ.getUser(userId);
    	if (user == null)
			return ResponseEntity.status(403).build();

    	return ResponseEntity.ok(gs.getAllGladiatorsNotOwnedBy(user));
    }

	@PutMapping(
			value="/gladiator/update",
			consumes={MediaType.APPLICATION_JSON_VALUE}
			)
	@ResponseBody
	public void updateGladiator(@RequestBody Gladiator g) {
		System.out.println("calling updateGladiator in GladiatorController");

		g.reconfigureHealth();
		gs.updateGladiator(g);
	}
	
}
