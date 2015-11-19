package com.tian.designpattern.builder;

/**
 * 
 * @author tian
 *
 * builder 模式 
 * 适用于有很多参数需要注入的场景
 * 大多数参数可选
 *
 */

@SuppressWarnings("unused")
public class JobDescription {
	
	private final String job;
	private final String jobId;
	private final String depart;
	private final String departId;
	private final int salary;
	
	public static class Builder {
		private String job;
		private String jobId;
		private String depart;
		private String departId;
		private int salary;
		
		public Builder(String job, String jobId) {
			this.job = job;
			this.jobId = jobId;
		}
		
		public Builder depart(String depart, String departId) {
			this.depart = depart;
			this.departId = departId;
			return this;
		}
		
		public Builder salary(int salary) {
			this.salary = salary;
			return this;
		}
		
		public JobDescription build() {
			return new JobDescription(this);
		}
	}
	
	private JobDescription(Builder builder) {
		this.job = builder.job;
		this.jobId = builder.jobId;
		this.depart = builder.depart;
		this.departId = builder.departId;
		this.salary = builder.salary;
	}
	
	public static void main(String[] args) {
		JobDescription jobDesc = new JobDescription.Builder("Developer", "001")
								.depart("Finance", "0001")
								.salary(10000)
								.build();
		System.out.println(jobDesc);
	}

}
