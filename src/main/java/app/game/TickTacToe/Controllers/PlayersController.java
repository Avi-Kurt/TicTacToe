package app.game.TickTacToe.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.game.TickTacToe.Beans.Player;
import app.game.TickTacToe.Exeptions.CustomException;
import app.game.TickTacToe.Services.PlayersServices;


@RestController
@Scope("prototype")
@RequestMapping("/Player")
//Player's Controllers Layer.
public class PlayersController {

	//Controller's Dependencies.
	@Autowired
	private PlayersServices playersServices;
	
	//Available Controllers.
	//1. Show Players Status in the DataBase.
//	@RequestMapping(value= "/showStats", consumes="application/json", method=RequestMethod.POST)
//	public ResponseEntity<?> showStats(@RequestBody Player player) {
//
//		//Console Log.
//		System.out.println("\n"+"Show Olayer Stats invoked: ");
//
////		try {
////		//	Player recivedPlayer = playersServices.createNewPlayer(player);
////			System.out.println("Message: Player Created Successfully! ");
////			System.out.println(recivedPlayer.toString()+"\n");
////			return new ResponseEntity<Player>(recivedPlayer, HttpStatus.OK);
////
////		} catch (CustomException exception) {
////			System.out.println("Message: Failed to Create a Player!");
////			System.out.println(exception.getMessage()+"\n");
////			return new ResponseEntity<CustomException>(exception, HttpStatus.BAD_REQUEST);
////		}
//	}
}
