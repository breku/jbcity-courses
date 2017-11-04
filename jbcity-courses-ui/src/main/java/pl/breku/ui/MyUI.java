package pl.breku.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 *
 */
@SpringUI(path = "")
@Theme("mytheme")
@Slf4j
@Component
public class MyUI extends AbstractUI {

	private static final long serialVersionUID = 1000504781843211331L;


	@Override
	protected void init(VaadinRequest request) {
		log.info("Request to url={}", ((SpringVaadinServletRequest) request).getRequestURI());
		initializeViews();
		navigateToCurrentRequest(request);
	}


}
