package com.bl.lms.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bl.lms.exception.UserException;
import com.bl.lms.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil implements Serializable {

//	@Value("${secret}")
	private String secret="This_is_a_secret_key";

	public String generateJWT(User user) {
		Map<String, Object> data = new HashMap<>();
		data.put("email", user.getEmailId());
		data.put("role", user.getRole());
		

		return Jwts.builder().setClaims(data).signWith(SignatureAlgorithm.HS512, secret).compact();

	}

	public String verify(String authorization) {
		try {
			 Claims data = Jwts.parser().setSigningKey(secret)
					 .parseClaimsJws(authorization).getBody();
			 return (String)data.get("email");
		} catch (Exception ex) {
			throw new UserException("Access Denied");
		}
	}
}

