package com.codingdojo.displaydate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class IndexController {
	@RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
	@RequestMapping("/time")
    public String time(Model model) {
		String timeFormat = "hh:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormat);
		String timeString = simpleDateFormat.format(new java.util.Date());
		model.addAttribute("time", timeString);
        return "time.jsp";
    }
	@RequestMapping("/date")
    public String date(Model model) {
		String dateFormat = "EEEEE, 'the' dd 'of' MMMMM, yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		String dateString = simpleDateFormat.format(new java.util.Date());
		model.addAttribute("date", dateString);
        return "date.jsp";
    }
}
