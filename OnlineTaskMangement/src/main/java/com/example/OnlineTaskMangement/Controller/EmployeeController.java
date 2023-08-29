package com.example.OnlineTaskMangement.Controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.OnlineTaskMangement.Dao.AssignTaskRepository;
import com.example.OnlineTaskMangement.Dao.ChangeRequestRepository;
import com.example.OnlineTaskMangement.Dao.EmployeeRepository;
import com.example.OnlineTaskMangement.Dao.TaskRepository;
import com.example.OnlineTaskMangement.Entity.AssignTask;
import com.example.OnlineTaskMangement.Entity.ChangeRequests;
import com.example.OnlineTaskMangement.Entity.Employee;
import com.example.OnlineTaskMangement.Entity.Task;
import com.example.OnlineTaskMangement.Service.EmployeeService;


@Controller
public class EmployeeController {
	
	static int id=0;
	
	@Autowired
	TaskRepository trep;
	@Autowired
	EmployeeRepository er;
	
	@Autowired
	EmployeeService es;
	@Autowired 
	AssignTaskRepository atr;
	
	@Autowired
	ChangeRequestRepository crr;
	
	@GetMapping("/login")
	public String addEmployee(){
		return "welcome";
		
	}
	@PostMapping("/Validate")
	public String Validate(@RequestParam("username")String username,
			@RequestParam("password")String password,ModelMap m) {
		if(username.equals("admin")&&password.equals("admin@123"))
			return "adminHome";
		if(er.findByEmpName(username).isEmpty()) {
			m.put("erroruser","User not found register first *");
			m.put("username", username);
			m.put("password", password);
			return "welcome";
		}else {
			if(er.findByEmpName(username).get().getPassword().equals(password)) {
				id=er.findByEmpName(username).get().getEmpId();
				return "employeeHome";
			}else {
				m.put("errorpass", "Invalid password");
				m.put("username", username);
				m.put("password", password);
			}
		}
		return "welcome";
	}
	@GetMapping("/reg")
	public String addRegister(ModelMap m){
		Employee emp =new Employee();
		m.put("emp",emp);
		return "register";
		
	}
	@PostMapping("/reg")
	public String addRegister(ModelMap m,Employee emp){
		if(er.findByEmpName(emp.getEmpName()).isPresent()) {
			String username="User Name Already Exists *";
			m.put("empname", username);
			m.put("emp", emp);
			return "register";
		}
		if(!emp.getPassword().equals(emp.getConfirmPassword())) {
			m.put("cpass","password missmatched");
			m.put("emp", emp);
			System.out.println(emp.getPassword()+" "+emp.getConfirmPassword());
			return "register";
		}
		es.addEmployee(emp);
		m.put("id", er.findByEmpName(emp.getEmpName()).get().getEmpId());
		return "successreg";
		
	}
	
	@GetMapping("/home")
	public String adminHome() {
		return "adminHome";
	}
	@GetMapping("/addTask")
	public String addTask(ModelMap m) {
     Task t = new Task();
     m.put("t", t);
     return "addtask";
     
	}
	@PostMapping("/addTask")
	public String addTasking(Task t,ModelMap m) {
    trep.save(t);
    m.put("message", "Task Added Successfully....");
     return "Success";
     
	}
	@GetMapping("/viewTasks")
	public String viewAlltasks(ModelMap m) {
		m.put("tasks", trep.findAll());
		return "displayTasks";
	}
	@GetMapping("/logout")
	public String logout() {
		return "welcome";
	}
	
	@GetMapping("/assignTask")
	public String assignTask(ModelMap m) {
		AssignTask at=new AssignTask();
		m.put("m", at);
		return "assignTask";
	}
	@PostMapping("/assignTask")
	public String assignTask(ModelMap mp,AssignTask m) {
		if(trep.findById(m.getTaskId()).isPresent()&& er.findById(m.getEmpId()).isPresent()) {
		mp.put("message", "Task id "+m.getTaskId()+" has Successfully assigned to employee Id "+m.getEmpId());
		atr.save(m);
		}else {
			mp.put("message","Either task id or employee id not found");
		}
		return "Success";
	}
	@GetMapping("/confirmdelete")
	public String confirm(@RequestParam("id") int id,ModelMap m) {
		m.put("id", id);
		return "confirm";
	}
	
	@GetMapping("/delete")
	public String deleteTasks(@RequestParam("id") int id) {
		trep.deleteById(id);
		return "redirect:viewTasks";
	}

	@GetMapping("/viewAssignTasks")
	public String viewAssigntasks(ModelMap m) {
		List<Integer> lis=atr.findallint(id);
		lis.forEach(System.out::println);
		m.put("tasks", trep.findByTaskIdIn(lis));
		trep.findByTaskIdIn(lis).forEach(System.out::println);
		return "employeeTasks";
	}
	@GetMapping("/change")
	public String change(@RequestParam("id") int id) {
		AssignTask ak=atr.findById(id).get();
		ChangeRequests cr=new ChangeRequests();
		cr.setEmployeeId(ak.getEmpId());
		cr.setTaskId(ak.getTaskId());
		cr.setStatus("pending");
		crr.save(cr);
		return "changeRequest";
	}
	
	@GetMapping("/status")
	public String status(ModelMap m) {
		m.put("req", crr.findByEmployeeId(id));
		return "requestsStatus";
	}
	@GetMapping("/ReviewTasks")
	public String review(ModelMap m) {
		m.put("review", crr.findrequests());
		return "reviewTasks";
	}
	@GetMapping("/action")
	public String action(@RequestParam("id") int id,@RequestParam("action") String action) {
		if(action.equals("accept")) {
			trep.deleteById(id);
			crr.UpdateStatus("accepted",id);
		}
		else {
			crr.UpdateStatus("rejected",id);
		}
	return "redirect:ReviewTasks";
	}
}
