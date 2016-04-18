package com.tian.enums;

/**
 * 
 * @author tian
 * 
 * 状态模式应分为：Context(环境)/State(状态)
 * Context包含状态引用
 * State包含与状态相关的逻辑处理
 * 
 */

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
