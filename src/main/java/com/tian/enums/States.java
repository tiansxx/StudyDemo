package com.tian.enums;

public enum States implements State {
	NEW {
		@Override
		public void process(State state) {
			System.out.println("Current State => " + this);
			RUNNABLE.process(this);
		}
	},
	RUNNABLE {
		@Override
		public void process(State state) {
			System.out.println("Current State => " + this);
			BLOCKED.process(this);
		}
	},
	BLOCKED {
		@Override
		public void process(State state) {
			System.out.println("Current State => " + this);
			WAITING.process(this);
		}
	},
	WAITING {
		@Override
		public void process(State state) {
			System.out.println("Current State => " + this);
			TIME_WAITING.process(this);
		}
	},
	TIME_WAITING {
		@Override
		public void process(State state) {
			System.out.println("Current State => " + this);
			TERMINATED.process(this);
		}
	},
	TERMINATED {
		@Override
		public void process(State state) {
			System.out.println("Current State => " + this);
			System.out.println("Finished!!!");
		}
	};

	@Override
	public void process(State state) {
		state.process(this);
	}

}
