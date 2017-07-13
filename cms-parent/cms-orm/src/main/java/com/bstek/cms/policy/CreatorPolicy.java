package com.bstek.cms.policy;

import java.lang.reflect.Field;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
import com.bstek.bdf3.dorado.jpa.policy.impl.GeneratorPolicy;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;

public class CreatorPolicy implements GeneratorPolicy {

	@Override
	public void apply(Object entity, Field field) {
		Assert.isAssignable(String.class, field.getType(), "Field type must be java.util.Date!");
		EntityState state = EntityUtils.getState(entity);
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (EntityState.NEW.equals(state)) {
			EntityUtils.setValue(entity, field.getName(), userDetails.getUsername());	
		}
		
	}

}
