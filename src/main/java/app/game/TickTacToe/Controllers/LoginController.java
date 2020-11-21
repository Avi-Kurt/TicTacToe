package app.game.TickTacToe.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import app.game.TickTacToe.Beans.Player;
import app.game.TickTacToe.Services.LoginService;

@RestController
@Scope("prototype")
@CrossOrigin("*")
//Login's Controllers Layer.
public class LoginController {

	//Controller's Dependencies.
	@Autowired
	private LoginService loginService;

	
	//Available Controllers.
	//1. Show Players Status in the DataBase.
	@RequestMapping(value= "/Login/{name}/{password}", method=RequestMethod.GET)
	public Player login(@PathVariable String name, @PathVariable String password) {
		
		//Server Response to Client.
		return loginService.loginToSystem(name, password);
	}
	
}
