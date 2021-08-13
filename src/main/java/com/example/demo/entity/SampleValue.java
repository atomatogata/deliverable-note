package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SampleValue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 1, max = 30, message = "だんだらけの三段畑")
	@NotBlank
	private String samplevalue;

	public SampleValue(int id, @Size(min = 1, max = 30, message = "だんだらけの三段畑") @NotBlank String samplevalue) {
		super();
		this.id = id;
		this.samplevalue = samplevalue;
	}


}
