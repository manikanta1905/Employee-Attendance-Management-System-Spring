//package Services_Cls;
//import java.time.Instant;
//import java.util.Optional;
//import java.util.UUID;
//
//import javax.transaction.Transactional;
//import org.springframework.stereotype.Service;
//import com.miniproject.module.AttendanceManagementSystem.Entity.ChangePassword;
//import com.miniproject.module.AttendanceManagementSystem.Entity.NotificationEmail;
//import com.miniproject.module.AttendanceManagementSystem.Entity.PasswordChangerRequest;
//import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import Repository_Cls.PasswordChangerRepo;
//import exception.AttendanceException;
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@Transactional
//@Slf4j
//public class PasswordChangerService {
//
//	private PasswordChangerRepo passwordrepo;
//	private MailService mailservice;
////	private final PasswordEncoder passwordencoder;
//	private EmployeeService employeeservice;
//
//	public PasswordChangerService(PasswordEncoder passwordencoder) {
//		this.passwordencoder = passwordencoder;
//	}
//	public void addVerification(String email) {
//		ChangePassword cg = new ChangePassword();
//		cg.setCreatedDate(Instant.now());
//		cg.setEmail(email);
//		String token = UUID.randomUUID().toString();
//		cg.setToken(token);
//		passwordrepo.save(cg);
//
//		mailservice.sendMail(new NotificationEmail("Please Change your Empployee Accoount " + email +" Password , use this verification token for changing password : " + token));
//
//	}
//
//	public Exception changePassword(PasswordChangerRequest request) {
//		Optional<ChangePassword> pctoken = passwordrepo.findByToken(request.getToken());
//		if(pctoken.isEmpty()) {
//			//log.error(" Token not found " + request.getEmail());
//			System.out.println("Token Not Found");
//			return new Exception("Token Not Found");
//		};
//
//		Optional<Employee> emp = employeeservice.getEmployee(pctoken.get().getEmail());
//		emp.orElseThrow( () ->{
//			//log.error("Employee not found " + request.getEmail());
//			System.out.println(" Employee not found " + request.getEmail());
//			return new AttendanceException(" Employee not found");
//		});
//
////		emp.get().setPassword(passwordencoder.encode((CharSequence) request.getPassword()));
////		employeeservice.updateEmployee(emp.get());
////
////		passwordrepo.deleteByToken(request.getToken());
//		return null;
//	}
//}
