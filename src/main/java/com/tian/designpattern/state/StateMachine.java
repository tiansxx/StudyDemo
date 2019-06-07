package com.tian.designpattern.state;

public class StateMachine {
	
	private State state;
	private Event event;
	
	public StateMachine(State state, Event event) {
		this.state = state;
		this.event = event;
	}
	
	public void doAction() {
		state.action(event);
	}
}
