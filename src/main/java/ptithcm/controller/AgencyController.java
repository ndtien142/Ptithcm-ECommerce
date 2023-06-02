package ptithcm.controller;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ptithcm.model.agency.Agency;
import ptithcm.service.AgencyService;


@Transactional
@Controller
@RequestMapping(value = "/admin/agency/")
public class AgencyController {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private AgencyService agencyService;
	
	@RequestMapping(value = "create")
	public String newAgency(ModelMap model) {
		return "admin/agency/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createAgency(ModelMap model, @RequestParam("agencyName") String agencyName, @RequestParam("email") String email,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("address") String address) {
		Agency agency = new Agency();
		agency.setName(agencyName);
		agency.setEmail(email);
		agency.setPhoneNumber(phoneNumber);
		agency.setAddress(address);
		
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(agency);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công! ");
			System.out.println("Them dai ly thanh cong");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại! ");
			System.out.println("Them moi dai ly that bai: " + e.toString());
			System.out.println(e);
		} finally {
			session.close();
		}
		
		return "redirect:/admin/agency/list.htm";
	}
	
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listAgencies(ModelMap model) {
		List<Agency> listAgencies = agencyService.getListAgencies();
		model.addAttribute("listAgencies", listAgencies);
		return "admin/agency/list";
	}
	
	@RequestMapping(value = "list/delete/{id}")
	public String deleteAgency(@PathVariable("id") Integer id) {
		System.out.println("hello");
		if (agencyService.deleteAgencyById(id) == 1) {
			System.out.println("Xoa thanh cong");
		}
		else {
			System.out.println("Xoa that bai");
		}
		return "redirect:/admin/agency/list.htm";
	}
}



