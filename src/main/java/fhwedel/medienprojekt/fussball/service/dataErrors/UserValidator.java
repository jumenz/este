package fhwedel.medienprojekt.fussball.service.dataErrors;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import fhwedel.medienprojekt.fussball.model.user.User;

public class UserValidator implements Validator {

    public boolean supports(Class candidate) {
        return User.class.isAssignableFrom(candidate);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required", "Field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required", "Field is required.");
    }

	@Override
	public <T> Set<ConstraintViolation<T>> validate(T object,
			Class<?>... groups) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateProperty(T object,
			String propertyName, Class<?>... groups) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType,
			String propertyName, Object value, Class<?>... groups) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDescriptor getConstraintsForClass(Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}
}

