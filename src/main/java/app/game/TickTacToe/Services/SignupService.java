package app.game.TickTacToe.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import app.game.TickTacToe.Beans.Player;
import app.game.TickTacToe.Repositories.PlayersRepository;

@Service
@Transactional
@Scope("prototype")
//Signup's Services Layer.
public class SignupService {

	//Injected Dependencies.
	@Autowired
	private PlayersRepository playersRepository;


	//Available Services.
	//1. System Sign-up Validation via Database.
	public Player signUpToSystem(Player player) {

		//Password Existence Validation.
		if(playersRepository.findByPassword(player.getPassword())!= null) {

			//Server Response to Client.
			return null;

		}

		//Saving Player in the Database.
		playersRepository.save(player);

		//Retrieve Existing Player from the Database.
		Player resultPlayer = playersRepository.findByNameAndPassword(player.getName(), player.getPassword());

		//Server Response to Client.
		return resultPlayer;
	}
	

}
