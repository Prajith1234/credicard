/**
 * 
 */
package com.credit.card.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sairam
 *
 */
@Table(name = "pancard")
@Entity
public class Pancard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 83902029L;
	@Id
	private String panCardNumber;
	@Column
	private float creditScore;

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public float getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(float creditScore) {
		this.creditScore = creditScore;
	}

	@Override
	public String toString() {
		return "Pancard [panCardNumber=" + panCardNumber + ", creditScore=" + creditScore + "]";
	}

}
