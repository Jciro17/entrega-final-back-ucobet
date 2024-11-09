package co.edu.uco.ucobet.generales.crosscutting.helpers;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.stereotype.Service;

@Service
public class SanitizerHelper {

    public String sanitizeInput(String input) {

    	String sanitized = Jsoup.clean(TextHelper.getDefault(input), Safelist.basic());
        return sanitized.isEmpty() ? TextHelper.EMPTY : sanitized;
    }
}

