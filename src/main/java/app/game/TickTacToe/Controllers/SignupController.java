package app.game.TickTacToe.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import app.game.TickTacToe.Beans.Player;
import app.game.TickTacToe.Services.SignupService;

@RestController
@Scope("prototype")
@CrossOrigin("*")
//Signup's Controllers Layer.
public class SignupController {

	//Controller's Dependencies.
	@Autowired
	private SignupService signupService;


	//Available Controllers.
	//1. Sign up New Player to the DataBase.
	@RequestMapping(value= "/Signup", consumes="application/json", method=RequestMethod.POST)
	public String signUp(@RequestBody Player player) {

		//Sign up Validation.
		if(signupService.signUpToSystem(player)== null) {

			//Server Response to Client.
			return "Failed to Sign Up, Please choose another password";
		}else {

			//Server Response to Client.
			return "New Player Signed up Successfully. Please Log in...";
		}
	}
}
