package demo.dao;

import java.util.List;

import demo.model.Poi;


public interface PoiDAO {
	Poi readPoi(long id);

	List<Poi> readAllPois();
}
