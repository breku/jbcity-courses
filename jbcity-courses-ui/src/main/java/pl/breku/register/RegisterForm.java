package pl.breku.register;

import com.vaadin.data.Binder;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.event.ShortcutAction;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import lombok.extern.slf4j.Slf4j;
import pl.breku.backend.database.entity.User;
import pl.breku.backend.security.RegisterService;
import pl.breku.ui.login.LoginPage;

/**
 * Created by breku on 04.11.17.
 */
@Slf4j
public class RegisterForm extends VerticalLayout {

	private static final long serialVersionUID = -954954302583570263L;

	private final RegisterService registerService;

	private final SpringNavigator springNavigator;


	private TextField email;

	private PasswordField passwordField1;

	private PasswordField passwordField2;

	private Button submit;

	private Binder<RegisterUser> binder = new Binder<>();

	public RegisterForm(RegisterService registerService, SpringNavigator springNavigator) {
		this.registerService = registerService;
		this.springNavigator = springNavigator;
		init();
	}

	private void init() {
		setSpacing(true);
		setSizeUndefined();
		final FormLayout registerForm = createRegisterForm();
		addComponent(registerForm);
		setComponentAlignment(registerForm, Alignment.TOP_CENTER);
	}


	private FormLayout createRegisterForm() {
		FormLayout loginForm = new FormLayout();
		loginForm.setSizeUndefined();

		email = new TextField("Email");
		passwordField1 = new PasswordField("Hasło");
		passwordField2 = new PasswordField("Powtórz hasło");


		binder.forField(email)
				.asRequired("Pole wymagane.")
				.withValidator(new EmailValidator("Niepoprawny email."))
				.bind(RegisterUser::getEmail, RegisterUser::setEmail);

		binder.forField(passwordField1)
				.asRequired("Pole wymagane.")
				.withValidator(new StringLengthValidator("Minimalna długość to 8 znaków.", 8, 64))
				.bind(RegisterUser::getPassword1, RegisterUser::setPassword1);

		binder.forField(passwordField2)
				.withValidator(x -> x.equals(passwordField1.getValue()), "Hasła nie są identyczne")
				.bind(RegisterUser::getPassword2, RegisterUser::setPassword2);


		RegisterUser user = new RegisterUser();

		binder.setBean(user);

		submit = new Button("Zarejestruj");
		loginForm.addComponent(email);
		loginForm.addComponent(passwordField1);
		loginForm.addComponent(passwordField2);
		loginForm.addComponent(submit);
		submit.addStyleName(ValoTheme.BUTTON_PRIMARY);
		submit.setDisableOnClick(true);
		submit.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		submit.addClickListener(e -> register());
		return loginForm;
	}

	private void register() {
		binder.validate();
		if (binder.isValid()) {
			log.info("Data is valid. Registering user");
			final RegisterUser bean = binder.getBean();
			User user = User.builder()
					.username(bean.getEmail())
					.password(bean.getPassword1())
					.build();
			final boolean successfull = registerService.registerUser(user);
			springNavigator.navigateTo(LoginPage.VIEW_NAME);
		} else {
			submit.setEnabled(true);
		}

	}
}
