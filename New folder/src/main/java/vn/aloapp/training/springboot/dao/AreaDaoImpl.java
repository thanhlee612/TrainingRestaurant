/**
 * 
 */
package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.Area;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;

/**
 * @author Long Nguyen
 *
 */
@Repository("areaDao")
@SuppressWarnings("unchecked")
public class AreaDaoImpl extends AbstractDao<Integer, Area> implements AreaDao {

	@SuppressWarnings("deprecation")
	@Override
	public Area findById(int id) {
	return (Area) this.getSession().createCriteria(Area.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Area> findAll() {
		CriteriaQuery<Area> criteria = this.getBuilder().createQuery(Area.class);
		Root<Area> root = criteria.from(Area.class);
		criteria.select(root);
		return this.getSession().createQuery(criteria).getResultList();
	}
	/******************************/
//find name
	//@SuppressWarnings("unchecked")
	@Override
	public StoreProcedureListResult<Area> spGlAreas(String name) throws Exception {
		// TODO Auto-generated method stub
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_gl_areas", Area.class)
				.registerStoredProcedureParameter("name", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("name", name);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<Area>(statusCode, messageError, query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public StoreProcedureListResult<Area> spGAllArea() {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_list_area", Area.class);
				return new StoreProcedureListResult<Area>(query.getResultList());
	}
	
	
	@Override
	public void update(Area entity) {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_area", Area.class)
				.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
		query.setParameter("name", entity.getName());
		query.execute();
	}
	
	
	

}
