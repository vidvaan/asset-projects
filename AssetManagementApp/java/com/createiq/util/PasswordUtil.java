package com.createiq.util;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public String generateSecurePassword() {

		// create character rule for lower case
		CharacterRule LCR = new CharacterRule(EnglishCharacterData.LowerCase);
		// set number of lower case characters
		LCR.setNumberOfCharacters(2);

		// create character rule for upper case
		CharacterRule UCR = new CharacterRule(EnglishCharacterData.UpperCase);
		// set number of upper case characters
		UCR.setNumberOfCharacters(2);

		// create character rule for digit
		CharacterRule DR = new CharacterRule(EnglishCharacterData.Digit);
		// set number of digits
		DR.setNumberOfCharacters(3);

		// create character rule for lower case
		CharacterRule SR = new CharacterRule(EnglishCharacterData.Special);
		// set number of special characters
		SR.setNumberOfCharacters(1);

		// create instance of the PasswordGenerator class
		PasswordGenerator passGen = new PasswordGenerator();

		// call generatePassword() method of PasswordGenerator class to get Passay
		// generated password
		String password = passGen.generatePassword(8, SR, LCR, UCR, DR);

		// return Passay generated password to the main() method
		return password;
	}

	public String encodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

}
