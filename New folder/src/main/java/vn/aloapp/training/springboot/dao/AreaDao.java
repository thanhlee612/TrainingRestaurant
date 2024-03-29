/**
 * 
 */
package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.Area;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;

/**
 * @author Long Nguyen
 *
 */
public interface AreaDao {

	Area create(Area entity);
	
	void update(Area entity);

	Area findById(int id);

	List<Area> findAll();

	StoreProcedureListResult<Area> spGlAreas(String name) throws Exception;
	
	StoreProcedureListResult<Area> spGAllArea();
	
	
	
	
}
