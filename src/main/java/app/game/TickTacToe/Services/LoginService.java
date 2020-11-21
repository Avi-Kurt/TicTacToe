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
//Login's Services Layer.
public class LoginService {

	//Injected Dependencies.
	@Autowired
	private PlayersRepository playersRepository;


	//Available Services.
	//1. System Login Validation via Database.
	public Player loginToSystem(String name, String password) {

		//Existence Validation.
		if(playersRepository.findByNameAndPassword(name, password)== null) {

			//Server Response to Client.
			return null;

		}

		//Retrieve Existing Player from the Database.
		Player resultPlayer = playersRepository.findByNameAndPassword(name, password);

		//Server Response to Client.
		return resultPlayer;
	}

}
