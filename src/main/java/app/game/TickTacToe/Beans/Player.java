package app.game.TickTacToe.Beans;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
//Players Spring Bean Model.
public class Player implements Serializable{

	//Instance Attributes.
	private static final long serialVersionUID = -3560860693180763365L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private int totalGames = 0;
	private int wins = 0;


	//Setters Methods.
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}

	//Getters Methods.
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public int getTotalGames() {
		return totalGames;
	}
	public int getWins() {
		return wins;
	}

}