package com.bitirmeprojesi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ayakkabi",schema = "ayakkabi")

public class Ayakkabi {
	
	@Id
	@Column(name="urun_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long urunId;
	
	@Column(name="urun_ismi" , nullable  = false)//boş geçilemez
	private String urunIsmi;
	
	@Column(name="urun_model" , nullable  = false)
	private String urunModel;
	
	@Column(name="urun_numara" , nullable  = false)
	private int urunNumara;
	
	@Column(name="urun_fiyat")
	private double satisFiyati;
	
	@Column(name="urun_stok")
	private int guncelStok;
	
	@Column(name="uretici_ulke")
	private String ureticiUlke;
	

	

}
