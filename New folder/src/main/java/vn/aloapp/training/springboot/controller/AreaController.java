/**
 *
 */
package vn.aloapp.training.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.Area;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDAreaRequest;
import vn.aloapp.training.springboot.response.AreaResponse;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.service.AreaService;

/**
 * @author kelvin
 *
 */
@RestController
@RequestMapping("/api/areas")
public class AreaController extends BaseController {

    @Autowired
    private AreaService areaService;

//   @RequestMapping(value = "/demo", method = RequestMethod.GET)
//   public List<Area> showAll(){
//	   List<Area> list = areaService.findAll();
//	   return list;	
//   }
//   @RequestMapping(value = "/{id}/demo", method = RequestMethod.GET)
//   public Area showId(@PathVariable("id") int id){
//	   return areaService.findById(id);
//   } 
   
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse> index(HttpServletRequest request,
                                              @RequestParam(name = "name", required = false, defaultValue = "") String name,
                                              @RequestParam(name = "status", required = false, defaultValue = "-1") int status) {
        BaseResponse responseArea = new BaseResponse();
        try {
            StoreProcedureListResult<Area> areas = areaService.spGlAreas(name);

            List<AreaResponse> data = new AreaResponse().mapToList(areas.getResult());

            responseArea.setData(data);

        } catch (Exception ex) {
            ex.printStackTrace();
            responseArea.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            responseArea.setMessageError(ex.getMessage());
        }
        return new ResponseEntity<BaseResponse>(responseArea, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse> test(HttpServletRequest request, @PathVariable("id") int id) {
        BaseResponse response = new BaseResponse();
        try {

        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessageError(ex.getMessage());
        }
        return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
    }

    
    
    //update
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse> update(HttpServletRequest request, @PathVariable("id") int id,
                                               @Valid @RequestBody CRUDAreaRequest wrapper) {
        BaseResponse response = new BaseResponse();
        try {
            Area area = areaService.findById(id);
            if (area == null) {
                response.setStatus(HttpStatus.BAD_REQUEST);
                response.setMessage(HttpStatus.BAD_REQUEST);
            } else {
                area.setName(wrapper.getName());
                areaService.update(area);
                response.setData(new AreaResponse(area));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessageError(ex.getMessage());
        }
        return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
    }

    
    
    /********************************************/
    // find all
    @RequestMapping(value="/list_area", method = RequestMethod.GET)
    public ResponseEntity<BaseResponse> spGAllArea(){
    	BaseResponse response = new BaseResponse();
    	StoreProcedureListResult<Area> area = areaService.spGAllArea();
    	response.setData(new AreaResponse().mapToList(area.getResult()));
    	return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
    }
    
    // find by name
    @GetMapping(value="/name")
    public ResponseEntity<BaseResponse> findName(@RequestParam(name = "keyword") String keyword){
    	BaseResponse response = new BaseResponse();
    	try {
			StoreProcedureListResult<Area> area = areaService.spGlAreas(keyword);
			response.setData(new AreaResponse().mapToList(area.getResult()));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
    }
    
    
    
    
}
