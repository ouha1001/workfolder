package demo.model;

import java.io.Serializable;

import javax.persistence.*;

import demo.model.converter.PositionConverter;


/**
 * The persistent class for the rateme_poi database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "Poi.findAll", query = "SELECT r FROM Poi r")
public class Poi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "osm_id")
	private Long osmId;

	@Column(name = "poi_type", nullable = false)
	private String poiType;

	@Column(nullable = false)
	@Convert(converter = PositionConverter.class)
	private Position position;

	public Poi() {
	}

	public Long getOsmId() {
		return this.osmId;
	}

	public void setOsmId(Long osmId) {
		this.osmId = osmId;
	}

	public String getPoiType() {
		return this.poiType;
	}

	public void setPoiType(String poiType) {
		this.poiType = poiType;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}