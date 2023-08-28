package com.Hibernateexcersie;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="UpdateLogTable")
public class UpdateLogTable {
	
	@Id
	@Column(name="Modification_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="Emp_id")
	private long Empcode;
	
	@Column(name="Modification_date")
	private Date modificationdate;
	
	@Column(name="UpdatedColumn")
	private String Updatecolumn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEmpcode() {
		return Empcode;
	}

	public void setEmpcode(long empcode) {
		Empcode = empcode;
	}

	public Date getModificationdate() {
		return modificationdate;
	}

	public void setModificationdate(Date modificationdate) {
		this.modificationdate = modificationdate;
	}

	public String getUpdatecolumn() {
		return Updatecolumn;
	}

	public void setUpdatecolumn(String updatecolumn) {
		Updatecolumn = updatecolumn;
	}

	public UpdateLogTable(long id, long empcode, Date modificationdate, String updatecolumn) {
		super();
		this.id = id;
		Empcode = empcode;
		this.modificationdate = modificationdate;
		Updatecolumn = updatecolumn;
	}
	public UpdateLogTable() {
		
	}

}
