package com.SpringIoc2;

public class Player {
	private String playerId;
	private String PlayerName;
	private Country country;
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return PlayerName;
	}
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Player(String playerId, String playerName, Country country) {
		super();
		this.playerId = playerId;
		PlayerName = playerName;
		this.country = country;
	}
	
}
